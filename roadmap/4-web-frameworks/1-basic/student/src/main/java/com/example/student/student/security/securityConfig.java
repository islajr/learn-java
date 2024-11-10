package com.example.student.student.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/student/getStudent/{id}",
                        "/student/hello").permitAll()

                .requestMatchers(
                        "/student/updateStudent/{id}",
                        "/student/deleteStudents",
                        "/student/getStudents",
                        "/student/register",
                        "/student/delete/{id}"
                ).hasRole("ADMIN")

                .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails first = User
                .withDefaultPasswordEncoder()
                .username("isla")
                .password("isla1234")
                .roles("ADMIN")
                .build();

        UserDetails second = User
                .withDefaultPasswordEncoder()
                .username("emma")
                .password("emma1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(first, second);
    }

}