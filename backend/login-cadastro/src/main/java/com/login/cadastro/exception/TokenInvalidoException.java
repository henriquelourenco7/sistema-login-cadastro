package com.login.cadastro.exception;

public class TokenInvalidoException extends RuntimeException {
	public TokenInvalidoException(String mensagem) {
		super(mensagem);
	}
}
