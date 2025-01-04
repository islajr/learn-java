package com.demo.student1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(customizer -> customizer.disable())
                /*.authorizeHttpRequests(requests -> requests.requestMatchers(
                        "/",
                        "/***")
                        .permitAll()
                        .anyRequest().authenticated())*/
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    protected AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authentication = new DaoAuthenticationProvider();
        authentication.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authentication.setUserDetailsService(userDetailsService);
        return authentication;

    }
}
