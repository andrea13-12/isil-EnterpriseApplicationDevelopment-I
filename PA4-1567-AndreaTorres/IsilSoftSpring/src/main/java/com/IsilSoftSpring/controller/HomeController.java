package com.IsilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.IsilSoftSpring.entity.Producto;
import com.IsilSoftSpring.repository.ProductoRepository;

@Controller 
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/gestionProducto")
	public String gestionProducto(Model model) {
		List<Producto> listaProducto = productoRepository.findAll();
		model.addAttribute("listaProducto",listaProducto);
		return "gestionProducto";
	}
}
