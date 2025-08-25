package com.isilErpSpring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilErpSpring.entity.OrdenCompra;

@Repository
public interface OrdenCompraRepository extends JpaRepository <OrdenCompra, Integer>{
	
	List<OrdenCompra> findAll();
	
	List<OrdenCompra> findByFechaBetween(Date fechaInicio, Date fechaFin);
	//para buscar por un rango de fecha findByFechaBetween
	
	OrdenCompra finById(int id);
}
