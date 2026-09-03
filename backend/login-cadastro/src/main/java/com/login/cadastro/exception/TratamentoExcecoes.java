package com.login.cadastro.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@ExceptionHandler(TelefoneJaCadastradoException.class)
	public ResponseEntity<String> tratarTelefoneJaCadastrado(TelefoneJaCadastradoException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> tratarValidacao(ConstraintViolationException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> tratarValidacaoArgumento(MethodArgumentNotValidException exception) {

		List<FieldError> erros = exception.getBindingResult().getFieldErrors();

		Map<String, String> mensagens = new HashMap<>();
		for (FieldError erro : erros) {
			mensagens.put(erro.getField(), erro.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagens);
	}
	
	@ExceptionHandler(CredenciaisInvalidasException.class)
	public ResponseEntity<String> tratarCredenciasInvalidas(CredenciaisInvalidasException exception){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
		
	}
}
