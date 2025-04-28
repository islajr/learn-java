package org.project.todoapp.security;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimiter extends OncePerRequestFilter {

    private final Bucket bucket;

    /*
    * Bandwidth type variable - limit - .classic() sets the capacity of requests per minute to 10, and the refill value to ten tokens per minute with the Refill.
    *
    * The Bucket builder class adds the limit of Bandwidth type with addLimit() and is initialized with .build().
    * Bucket.tryConsume()
    *
    * bucket4j also allows us to set multiple limits to enable finer-grain access control of the rate limits.
    * */

    public RateLimiter() {
        Bandwidth limit = Bandwidth.classic(10, Refill.intervally(10, Duration.ofMinutes(1)));

        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);   // should be TOO MANY REQUESTS
            response.getWriter().write("Too many requests - try again later.");
        }
    }
}
