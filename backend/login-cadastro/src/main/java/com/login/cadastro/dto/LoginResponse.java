package com.login.cadastro.dto;

import com.login.cadastro.entity.Usuario;

public class LoginResponse {

	private String mensagem = "Bem vindo";
	private String nome;
	private String token;

	public String getMensagem() {
		return mensagem;
	}

	public String getNome() {
		return nome;
	}

	public LoginResponse(Usuario usuario, String token) {
		this.nome = usuario.getNome();
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
