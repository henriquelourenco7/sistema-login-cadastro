package com.login.cadastro.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final UsuarioDetailsService usuarioDetailsService;

	public JwtAuthenticationFilter(JwtService jwtService, UsuarioDetailsService usuarioDetailsService) {
		this.jwtService = jwtService;
		this.usuarioDetailsService = usuarioDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader("Authorization");

		if (token != null && token.startsWith("Bearer ")) {
			String jwt = token.substring(7);
			String email = null;
			try {
				email = jwtService.extractUsername(jwt);
				if (email != null) {
					
					UserDetails userDetails = usuarioDetailsService.loadUserByUsername(email);
					if (SecurityContextHolder.getContext().getAuthentication() == null) {
						
						if(userDetails.isEnabled() && userDetails.isAccountNonLocked()) {
							UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
									userDetails, null, userDetails.getAuthorities());
							SecurityContextHolder.getContext().setAuthentication(authentication);
						}
					}
				}
			} catch (JwtException e) {
				SecurityContextHolder.clearContext();
			} catch (UsernameNotFoundException e) {
				SecurityContextHolder.clearContext();
			}

		}
		filterChain.doFilter(request, response);
	}
}
