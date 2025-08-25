package com.IsilSoftSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IsilSoftSpring.entity.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

	List<Tienda>findAll();
	List<Tienda>findByDistritoContains(String distrito);
	
	Tienda findByColaboradorId(Integer id);

}
