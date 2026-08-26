package com.login.cadastro.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.cadastro.entity.Usuario;
import com.login.cadastro.exception.EmailJaCadastradoException;
import com.login.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;

	}

	public Usuario cadastrar(Usuario usuario) {

		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new EmailJaCadastradoException("E-mail ja cadastrado");
		}
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

		return usuarioRepository.save(usuario);
	}

}
