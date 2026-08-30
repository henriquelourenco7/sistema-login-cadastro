package com.login.cadastro.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.cadastro.dto.UsuarioRequest;
import com.login.cadastro.dto.UsuarioResponse;
import com.login.cadastro.entity.Usuario;
import com.login.cadastro.exception.EmailJaCadastradoException;
import com.login.cadastro.exception.TelefoneJaCadastradoException;
import com.login.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;

	}

	public UsuarioResponse cadastrar(UsuarioRequest usuario) {
		
		Usuario novoUsuario = new Usuario();
		
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());
		novoUsuario.setTelefone(usuario.getTelefone());
		novoUsuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		novoUsuario.setData_nascimento(usuario.getData_nascimento());

		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new EmailJaCadastradoException("E-mail ja cadastrado");
		}
		

		if (usuarioRepository.existsByTelefone(usuario.getTelefone())) {
			throw new TelefoneJaCadastradoException("Telefone ja cadastrado");
		}
		
		Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);
		return new UsuarioResponse(usuarioSalvo);
	}

}
