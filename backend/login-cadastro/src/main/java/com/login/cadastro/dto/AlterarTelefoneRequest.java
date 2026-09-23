package com.login.cadastro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AlterarTelefoneRequest {

	@NotBlank
	@Pattern(regexp = "[0-9]{11}")
	private String novoTelefone;

	public String getNovoTelefone() {
		return novoTelefone;
	}

	public void setNovoTelefone(String novoTelefone) {
		this.novoTelefone = novoTelefone;
	}
}
