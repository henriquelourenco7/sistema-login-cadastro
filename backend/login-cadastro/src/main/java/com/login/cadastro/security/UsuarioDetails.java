package com.login.cadastro.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.login.cadastro.entity.StatusUsuario;
import com.login.cadastro.entity.Usuario;

public class UsuarioDetails implements UserDetails {

	private Usuario usuario;

	public UsuarioDetails(Usuario usuario) {
		this.usuario = usuario;

	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getTipo_usuario().name()));
	}

	@Override
	public boolean isEnabled() {
		return usuario.getStatus() == StatusUsuario.ATIVA;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return usuario.getStatus() != StatusUsuario.BLOQUEADA;
	}
	
	@Override 
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
