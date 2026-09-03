package com.login.cadastro.dto;

import com.login.cadastro.entity.Usuario;

public class LoginResponse {

	private String mensagem = "Bem vindo";
	private String nome;

	public String getMensagem() {
		return mensagem;
	}

	public String getNome() {
		return nome;
	}

	public LoginResponse(Usuario usuario) {
		this.nome = usuario.getNome();
	}
}
