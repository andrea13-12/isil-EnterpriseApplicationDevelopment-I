package com.IsilSoftSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IsilSoftSpring.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findAll();
	
	Usuario findByCorreoAndPassword(String corre, String password);
	
}
