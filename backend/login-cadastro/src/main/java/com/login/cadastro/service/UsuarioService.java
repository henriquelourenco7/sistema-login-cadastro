package com.login.cadastro.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.cadastro.dto.LoginRequest;
import com.login.cadastro.dto.LoginResponse;
import com.login.cadastro.dto.UsuarioRequest;
import com.login.cadastro.dto.UsuarioResponse;
import com.login.cadastro.entity.RecuperacaoSenha;
import com.login.cadastro.entity.StatusUsuario;
import com.login.cadastro.entity.Usuario;
import com.login.cadastro.exception.CredenciaisInvalidasException;
import com.login.cadastro.exception.EmailJaCadastradoException;
import com.login.cadastro.exception.TelefoneJaCadastradoException;
import com.login.cadastro.repository.RecuperacaoSenhaRepository;
import com.login.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final RecuperacaoSenhaRepository recuperacaoSenhaRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
			RecuperacaoSenhaRepository recuperacaoSenhaRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
		this.recuperacaoSenhaRepository = recuperacaoSenhaRepository;

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

	public LoginResponse login(LoginRequest usuario) {

		Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());

		if (usuarioEncontrado == null) {

			throw new CredenciaisInvalidasException("Email ou senha invalidos");
		}

		if (!passwordEncoder.matches(usuario.getSenha(), usuarioEncontrado.getSenha())) {
			throw new CredenciaisInvalidasException("Email ou senha invalidos");
		}

		if (usuarioEncontrado.getStatus() == StatusUsuario.ATIVA) {
			return new LoginResponse(usuarioEncontrado);
		}
		throw new CredenciaisInvalidasException("Email ou senha invalidos");

	}

	public void solicitarRecuperacao(String email) {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {

		}
		RecuperacaoSenha recuperacao = new RecuperacaoSenha();
		recuperacao.setUsuario(usuario);

		
	}

}
