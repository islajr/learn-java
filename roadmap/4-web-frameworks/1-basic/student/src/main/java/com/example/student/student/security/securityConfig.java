package com.example.student.student.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class securityConfig {

    protected void init(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("islajr")
                .password(passwordEncoder().encode("isla123"))
                .roles("ADMIN")

                .and()
                .passwordEncoder(passwordEncoder())
                .withUser("user")
                .password(passwordEncoder().encode("user123"))
                .roles("BASIC");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(
                        "/student/getStudent/{id}",
                        "/student/updateStudent/{id}",
                        "/student/hello"
                )
                .hasAnyRole("BASIC", "ADMIN")

                .requestMatchers(
                        "/student/delete/{id}",
                        "/student/register",
                        "/student/getStudents",
                        "/student/deleteStudents",
                        "/student/updateStudent/{id}"
                )
                .hasRole("ADMIN")

                .requestMatchers("/")
                .permitAll()

                .anyRequest()
                .authenticated();
    }
}