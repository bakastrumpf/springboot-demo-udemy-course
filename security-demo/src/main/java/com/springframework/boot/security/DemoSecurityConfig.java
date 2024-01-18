package com.springframework.boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailManager() {
		
		UserDetails brenda = User.builder()
				.username("brenda")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails dylan = User.builder()
				.username("dylan")
				.password("{noop}test124")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails donna = User.builder()
				.username("donna")
				.password("{noop}test125")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails david = User.builder()
				.username("david")
				.password("{noop}test126")
				.roles("EMPLOYEE","MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(brenda, dylan, donna, david);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
			configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				// ** is a wild card that will match all sub-paths
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				// to update an existing employee:
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
			);
		
		// use http basic auth
		http.httpBasic(Customizer.withDefaults());
		
		// disable csrf - Cross Site Request Forgery
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
	}
}
