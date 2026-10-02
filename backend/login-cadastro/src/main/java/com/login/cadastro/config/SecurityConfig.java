package com.login.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    http
	    	.csrf(csrf -> csrf.disable())
	    	.authorizeHttpRequests(auth -> auth
		        .requestMatchers("/usuarios").permitAll()
		        .requestMatchers("/login").permitAll()
		        .requestMatchers("/recuperacao-senha").permitAll()
		        .requestMatchers("/validar-token").permitAll()
		        .requestMatchers("/recuperacao-senha/redefinir").permitAll()
		        .anyRequest().authenticated()
	    	);

	    return http.build();
	}
	
}
