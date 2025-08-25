package com.IsilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.IsilSoftSpring.entity.Producto;
import com.IsilSoftSpring.entity.Tienda;
import com.IsilSoftSpring.repository.ProductoRepository;
import com.IsilSoftSpring.repository.TiendaRepository;

@Controller 
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	TiendaRepository tiendaRepository;
	
	@GetMapping("/gestionProducto")
	public String gestionProducto(Model model) {
		List<Producto> listaProducto = productoRepository.findAll();
		model.addAttribute("listaProducto",listaProducto);
		return "gestionProducto";
	}
	
	@GetMapping("/gestionarTienda")
	public String gestionarTienda(Model model) {
		List<Tienda> listaTiendas = tiendaRepository.findAll();
		model.addAttribute("listaTiendas", listaTiendas);
		
		return "gestionarTienda";
	}
}
