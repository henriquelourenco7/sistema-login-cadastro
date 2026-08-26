package com.login.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.cadastro.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	boolean existsByEmail(String email);
}
