package com.isilErpSpring.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilErpSpring.entity.Insumo;
import com.isilErpSpring.entity.OrdenCompra;
import com.isilErpSpring.repository.InsumoRepository;
import com.isilErpSpring.repository.OrdenCompraRepository;

@Controller
@RequestMapping("/ordenCompra")
public class OrdenCompraController {
	
	@Autowired
	OrdenCompraRepository ordenCompraRepository;
	
	@Autowired
	InsumoRepository insumoRepository;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("fechaInicio")Date fechaInicio, @RequestParam("fechaFin")Date fechaFin, Model model) {
		List<OrdenCompra> listaOrdenCompra = ordenCompraRepository.findByFechaBetween(fechaInicio, fechaFin);
		model.addAttribute("listaOrdenCompra",listaOrdenCompra);
		
		return "gestionOrdenCompra";
	}
	
	@GetMapping("/agregarDetalle/{id}")
	public String agregarDetalle(@PathVariable("id")int id, Model model) {
		OrdenCompra ordenCompra = ordenCompraRepository.finById(id);
		model.addAttribute("ordenCompra", ordenCompra);
		
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		
		return "agregarDetalleOrdenCompra";
	}
}
