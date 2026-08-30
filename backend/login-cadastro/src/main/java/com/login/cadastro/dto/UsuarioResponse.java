package com.login.cadastro.dto;

import java.time.LocalDate;

import com.login.cadastro.entity.StatusUsuario;
import com.login.cadastro.entity.TipoUsuario;
import com.login.cadastro.entity.Usuario;

public class UsuarioResponse {
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private LocalDate data_nascimento;
	private TipoUsuario tipo_usuario;
	private StatusUsuario status;
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.data_nascimento = usuario.getData_nascimento();
		this.tipo_usuario = usuario.getTipo_usuario();
		this.status = usuario.getStatus();
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}
	public StatusUsuario getStatus() {
		return status;
	}
}
