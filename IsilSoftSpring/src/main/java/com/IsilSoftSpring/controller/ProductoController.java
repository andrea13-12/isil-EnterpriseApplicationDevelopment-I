package com.IsilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.IsilSoftSpring.entity.Producto;
import com.IsilSoftSpring.repository.ProductoRepository;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoRepository productoRepository;

	@RequestMapping("/buscar")
	public String buscar (@RequestParam("categoria")String categoria, Model model) {
		List<Producto> listaProducto = productoRepository.findByCategoriaContains(categoria);
		model.addAttribute("listaProducto", listaProducto);
		return "gestionProducto";
	}
}
