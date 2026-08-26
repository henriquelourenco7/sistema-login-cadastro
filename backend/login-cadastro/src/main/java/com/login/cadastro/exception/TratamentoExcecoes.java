package com.login.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoExcecoes {

	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<String> tratarEmailJaCadastrado(EmailJaCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}
}

