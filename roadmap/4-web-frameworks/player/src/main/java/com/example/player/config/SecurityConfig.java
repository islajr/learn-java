package com.example.player.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        // disabling csrf
                .csrf(customizer -> customizer.disable())

        //making web server able to authorize http requests
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())

        // initiating form login
                .formLogin(Customizer.withDefaults())

        // making it accessible to postman
                .httpBasic(Customizer.withDefaults())

        // making csrf stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();

        @Bean
    }
}
