package com.login.cadastro.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.cadastro.dto.LoginRequest;
import com.login.cadastro.dto.LoginResponse;
import com.login.cadastro.dto.UsuarioRequest;
import com.login.cadastro.dto.UsuarioResponse;
import com.login.cadastro.entity.RecuperacaoSenha;
import com.login.cadastro.entity.StatusRecuperacaoSenha;
import com.login.cadastro.entity.StatusUsuario;
import com.login.cadastro.entity.Usuario;
import com.login.cadastro.exception.CredenciaisInvalidasException;
import com.login.cadastro.exception.EmailJaCadastradoException;
import com.login.cadastro.exception.TelefoneJaCadastradoException;
import com.login.cadastro.exception.TokenInvalidoException;
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
			return;
		}

		RecuperacaoSenha recuperacaoPendente = recuperacaoSenhaRepository.findFirstByUsuarioAndStatusOrderByExpiracaoDesc(usuario,
				StatusRecuperacaoSenha.PENDENTE);

		if (recuperacaoPendente == null || recuperacaoPendente.getExpiracao().isBefore(LocalDateTime.now())) {

			RecuperacaoSenha recuperacao = new RecuperacaoSenha();
			recuperacao.setUsuario(usuario);

			SecureRandom random = new SecureRandom();
			int token = 100000 + random.nextInt(900000);
			String tokenString = String.valueOf(token);
			recuperacao.setToken(tokenString);

			LocalDateTime expiracao = LocalDateTime.now().plusMinutes(15);
			recuperacao.setExpiracao(expiracao);

			recuperacao.setStatus(StatusRecuperacaoSenha.PENDENTE);

			recuperacaoSenhaRepository.save(recuperacao);

		}

	}

	public void validarToken(String token) {

		RecuperacaoSenha tokenRecebido = recuperacaoSenhaRepository.findByToken(token);

		if (tokenRecebido == null) {
			throw new TokenInvalidoException("Token de recuperação inexistente ou invalido");
		}

		if (tokenRecebido.getStatus() == StatusRecuperacaoSenha.USADO) {
			throw new TokenInvalidoException("Token de recuperação inexistente ou invalido");
		}

		if (tokenRecebido.getExpiracao().isBefore(LocalDateTime.now())) {
			throw new TokenInvalidoException("Token de recuperação inexistente ou invalido");
		}
	}

}
