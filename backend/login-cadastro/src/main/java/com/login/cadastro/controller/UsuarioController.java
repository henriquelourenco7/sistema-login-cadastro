package com.login.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
