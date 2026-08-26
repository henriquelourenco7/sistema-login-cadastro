package com.login.cadastro.repository;

import com.login.cadastro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	boolean existsByEmail(String email);
}
