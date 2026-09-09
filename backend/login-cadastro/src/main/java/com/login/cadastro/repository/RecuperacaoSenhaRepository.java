package com.login.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.cadastro.entity.RecuperacaoSenha;
import com.login.cadastro.entity.StatusRecuperacaoSenha;
import com.login.cadastro.entity.Usuario;

public interface RecuperacaoSenhaRepository extends JpaRepository<RecuperacaoSenha, Integer> {
	RecuperacaoSenha findByToken(String token);
	RecuperacaoSenha findByUsuarioAndStatus(Usuario usuario, StatusRecuperacaoSenha status);

}
