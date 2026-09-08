package com.login.cadastro.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recuperacao_senha")
public class RecuperacaoSenha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@NotNull
	private Usuario usuario;
	@NotBlank
	private String token;
	@NotNull
	private LocalDateTime expiracao;
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusRecuperacaoSenha status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(LocalDateTime expiracao) {
		this.expiracao = expiracao;
	}
	public StatusRecuperacaoSenha getStatus() {
		return status;
	}
	public void setStatus(StatusRecuperacaoSenha status) {
		this.status = status;
	}
}
