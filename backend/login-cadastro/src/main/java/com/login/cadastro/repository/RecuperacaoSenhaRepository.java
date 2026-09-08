package com.login.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.cadastro.entity.RecuperacaoSenha;

public interface RecuperacaoSenhaRepository extends JpaRepository<RecuperacaoSenha, Integer>{
	RecuperacaoSenha findByToken(String token);
	
}
