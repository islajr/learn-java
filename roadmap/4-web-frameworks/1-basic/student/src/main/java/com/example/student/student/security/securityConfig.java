package com.example.student.student.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/student/getStudent/{id}",
                        "/student/hello").hasAnyRole("USER", "ADMIN")

                .requestMatchers(
                        "/student/updateStudent/{id}",
                        "/student/deleteStudents",
                        "/student/getStudents",
                        "/student/register",
                        "/student/delete/{id}"
                ).hasRole("ADMIN")

                .anyRequest().authenticated()
        )
                .formLogin((form) -> form.permitAll())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("isla")
                        .password("isla123")
                        .roles("ADMIN")
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("emma")
                        .password("emma123")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}