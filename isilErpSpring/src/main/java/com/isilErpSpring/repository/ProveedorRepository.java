package com.isilErpSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isilErpSpring.entity.Proveedor;

//REPOSITORY REMPLAZA AL DAO!!!!

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

	//el metodo es FINDALL
	//devuelve una lista
	List<Proveedor> findAll();
	
	List<Proveedor> findByRazonSocialContains(String razonSocial);
	
	//buscamos un proveedor por ruc 
	//devuelve un solo Proveedor
	Proveedor findByRuc(String ruc);
	Proveedor finById(int id);
	
	//metodo que elimina 
	//colocamos transactional porq es el que otorga el permiso para el delete
	@Transactional
	void deleteById(int id);
	
	
	
}
