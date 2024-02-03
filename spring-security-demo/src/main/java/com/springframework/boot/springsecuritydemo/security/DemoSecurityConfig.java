package com.springframework.boot.springsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails brenda = User.builder()
                .username("brenda")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails dylan = User.builder()
                .username("dylan")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails donna = User.builder()
                .username("donna")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails david = User.builder()
                .username("david")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(brenda, dylan, donna, david);

    }
}
