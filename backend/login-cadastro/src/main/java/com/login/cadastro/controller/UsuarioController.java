package com.login.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.cadastro.entity.Usuario;
import com.login.cadastro.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/usuarios")
	public Usuario cadastrar(@RequestBody @Valid Usuario usuario) {
		return usuarioService.cadastrar(usuario);
	}
}
