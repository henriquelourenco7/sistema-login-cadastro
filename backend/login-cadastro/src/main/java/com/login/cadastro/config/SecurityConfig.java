package com.login.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.login.cadastro.security.UsuarioDetailsService;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(UsuarioDetailsService usuarioDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(usuarioDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
}
