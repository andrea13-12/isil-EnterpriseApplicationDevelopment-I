package com.isilErpSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isilErpSpring.entity.TipoInsumo;

@Repository
public interface TipoInsumoRepository extends JpaRepository<TipoInsumo, Integer> {

	List<TipoInsumo> findAll();
}
