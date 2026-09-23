package com.login.cadastro.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.cadastro.dto.AlterarEmailRequest;
import com.login.cadastro.dto.AlterarSenhaRecuperacaoRequest;
import com.login.cadastro.dto.LoginRequest;
import com.login.cadastro.dto.LoginResponse;
import com.login.cadastro.dto.RecuperacaoSenhaRequest;
import com.login.cadastro.dto.TokenRequest;
import com.login.cadastro.dto.UsuarioRequest;
import com.login.cadastro.dto.UsuarioResponse;
import com.login.cadastro.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/usuarios")
	public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioRequest usuario) {
		return usuarioService.cadastrar(usuario);
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody @Valid LoginRequest login) {
		return usuarioService.login(login);
	}

	@PostMapping("/recuperacao-senha")
	public void solicitarRecuperacao(@RequestBody @Valid RecuperacaoSenhaRequest recuperacao) {
		usuarioService.solicitarRecuperacao(recuperacao.getEmail());

	}

	@PostMapping("/validar-token")
	public void validarToken(@RequestBody TokenRequest token) {
		usuarioService.validarToken(token.getToken());
	}

	@PostMapping("/recuperacao-senha/redefinir")
	public void alterarSenhaRecuperacao(@RequestBody @Valid AlterarSenhaRecuperacaoRequest dados) {
		usuarioService.alterarSenhaRecuperacao(dados);
	}

	@PutMapping("/usuarios/{id}/email")
	public void alterarEmail(@PathVariable Integer id, @RequestBody @Valid AlterarEmailRequest email) {
		usuarioService.alterarEmail(id, email);
	}
}
