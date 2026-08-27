package com.login.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class TratamentoExcecoes {

	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<String> tratarEmailJaCadastrado(EmailJaCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> tratarValidacao(ConstraintViolationException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> tratarValidacaoArgumento(MethodArgumentNotValidException exception) {

	    FieldError erro = exception.getBindingResult().getFieldError();
	    String mensagem = erro.getField() + ": " + erro.getDefaultMessage();
	    		

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(mensagem);
	}
}
