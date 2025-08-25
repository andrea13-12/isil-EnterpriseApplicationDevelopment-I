package com.isilErpSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilErpSpring.entity.Usuario;

//REPOSITORY REMPLAZA AL DAO!!!!

@Repository
//jpaRepository necesita el nombre de la tabla + el tipo de la PK 

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//va a devolver una lista
	//colocar el find en el metodo es = select*
	List<Usuario> findAll();
	//findby = select * Where
	Usuario findByCorreoAndPassword(String corre, String password);
	// Actualizar & Insert = save
	
	//para buscar correos
	Usuario findByCorreo(String correo);
	
}
