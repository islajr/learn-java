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

        // disabling csrf
        http.csrf(customizer -> customizer.disable());

        //making web server able to authorize http requests
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        // initiating form login
        http.formLogin(Customizer.withDefaults());

        // making it accessible to postman
        http.httpBasic(Customizer.withDefaults());

        // making csrf stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
