package com.login.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.login.cadastro.security.JwtAuthenticationFilter;
import com.login.cadastro.security.JwtService;
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
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter (JwtService jwtService, UsuarioDetailsService usuarioDetailsService) {
		return new JwtAuthenticationFilter(jwtService,usuarioDetailsService);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, DaoAuthenticationProvider authenticationProvider, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> 
		    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(
			             "/usuarios",
			             "/login",
			             "/recuperacao-senha",
			             "/validar-token",
			             "/recuperacao-senha/redefinir")
					.permitAll()
					
					.anyRequest().authenticated()
			);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
}
