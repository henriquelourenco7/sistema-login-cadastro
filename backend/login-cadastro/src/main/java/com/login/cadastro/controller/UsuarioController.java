package com.login.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public LoginResponse login(@RequestBody @Valid LoginRequest usuario) {
		return usuarioService.login(usuario);
	}

	@PostMapping("/recuperacao-senha")
	public void solicitarRecuperacao(@RequestBody @Valid RecuperacaoSenhaRequest usuario) {
		usuarioService.solicitarRecuperacao(usuario.getEmail());

	}
	
	@PostMapping("/validar-token")
	public void validarToken(@RequestBody TokenRequest token) {
		usuarioService.validarToken(token.getToken());
	}
}
