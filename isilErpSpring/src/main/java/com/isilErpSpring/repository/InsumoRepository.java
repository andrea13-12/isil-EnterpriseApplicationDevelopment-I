package com.isilErpSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isilErpSpring.entity.Insumo;
import com.isilErpSpring.entity.TipoInsumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer>
{
	Insumo findById(int id);
	List<Insumo>findAll();
	
	//un metedo que busque la lista de insumo pero por TIPO
	//el tipo es un OBJETO
	//el espera un obj del tipo
	List<Insumo>findbyTipo(TipoInsumo tipo);
	
	//es el permiso que le damos para que pueda realizar cambios bruscos como eliminar 
	@Transactional
	void deleteByid(int id);
}
