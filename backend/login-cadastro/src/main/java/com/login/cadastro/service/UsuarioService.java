package com.login.cadastro.service;

import org.springframework.stereotype.Service;
import com.login.cadastro.repository.UsuarioRepository;
import com.login.cadastro.entity.Usuario;
import com.login.cadastro.exception.EmailJaCadastradoException;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;

	}

	public Usuario cadastrar(Usuario usuario) {

		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new EmailJaCadastradoException("E-mail ja cadastrado");
		}
		return usuarioRepository.save(usuario);
	}

}
