package com.login.cadastro.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}