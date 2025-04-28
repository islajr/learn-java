package org.project.todoapp.security;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.project.todoapp.model.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimiter extends OncePerRequestFilter {

    /*
    * Bandwidth type variable - limit - .classic() sets the capacity of requests per minute to 10, and the refill value to ten tokens per minute with the Refill.
    *
    * The Bucket builder class adds the limit of Bandwidth type with addLimit() and is initialized with .build().
    * Bucket.tryConsume()
    *
    * bucket4j also allows us to set multiple limits to enable finer-grain access control of the rate limits.
    * */

        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMinutes(1)));

        Map<String, Bucket> storage = new ConcurrentHashMap<>();

        private Bucket createBucket() {
            return Bucket.builder()
                    .addLimit(limit)
                    .build();
        }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String validator = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail() != null ? ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail() : request.getRemoteAddr();

        Bucket bucket = storage.computeIfAbsent(validator, b -> createBucket());

        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());   // should be TOO MANY REQUESTS
            response.getWriter().write("You are currently rate-limited - try again later.");
        }
    }
}
