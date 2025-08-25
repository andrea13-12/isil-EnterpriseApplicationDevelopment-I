package com.IsilSoftSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IsilSoftSpring.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto>findAll();
	List<Producto>findByCategoriaContains(String categoria);
}
