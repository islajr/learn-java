package com.example.player.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityAuthentication {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users.username("userone").password("passwordOne").roles("USER").build();
        UserDetails userTwo = users.username("usertwo").password("passwordTwo").roles("USER").build();

        return new InMemoryUserDetailsManager(user, userTwo);
    }
}
