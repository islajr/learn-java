package com.projects.weatherapi.config;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterChain {

    private final RateLimiter rateLimiter;

    public FilterChain(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Bean
    public FilterRegistrationBean<Filter> preDispatchFilter() {
        FilterRegistrationBean<Filter> rateLimiterFilter = new FilterRegistrationBean<>();
        rateLimiterFilter.setFilter(rateLimiter);

        rateLimiterFilter.addUrlPatterns("/*"); // applies to all URL patterns
        rateLimiterFilter.setOrder(Ordered.HIGHEST_PRECEDENCE); // sets the order of precedence
        return rateLimiterFilter;
    }
}
