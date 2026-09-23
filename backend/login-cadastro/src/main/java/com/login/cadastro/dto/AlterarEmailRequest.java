package com.login.cadastro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlterarEmailRequest {
	
	@Email
	@NotBlank
	private String novoEmail;

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}
}
