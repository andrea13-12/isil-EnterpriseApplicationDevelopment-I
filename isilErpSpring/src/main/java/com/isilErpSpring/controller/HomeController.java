package com.isilErpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isilErpSpring.entity.Insumo;
import com.isilErpSpring.entity.OrdenCompra;
import com.isilErpSpring.entity.Proveedor;
import com.isilErpSpring.entity.TipoInsumo;
import com.isilErpSpring.repository.InsumoRepository;
import com.isilErpSpring.repository.OrdenCompraRepository;
import com.isilErpSpring.repository.ProveedorRepository;
import com.isilErpSpring.repository.TipoInsumoRepository;


@Controller
@RequestMapping("/home")
public class HomeController {

	//Nos permite trabajar la interfas como un objeto (Autowired)
	//Lo cambia a constructor 
	@Autowired
	ProveedorRepository proveedorRepository;
	@Autowired
	InsumoRepository insumoRepository;
	@Autowired
	TipoInsumoRepository tipoInsumoRepository;
	
	@Autowired
	OrdenCompraRepository ordenCompraRepository;
	
	@GetMapping("/gestionProveedor")
	public String gestionProveedor(Model model) {
		
		//LIST SE IMPORTA DE JAVAUTIL
		List<Proveedor> listaProveedores = proveedorRepository.findAll();
		model.addAttribute("listaProveedores",listaProveedores);
		return "gestionProveedor";
	}
	
	@GetMapping("/gestionInsumo")
	public String gestionInsumo(Model model) {
		List<Insumo> listaInsumos = insumoRepository.findAll();
		List<TipoInsumo> listaTiposInsumo = tipoInsumoRepository.findAll();
		
		model.addAttribute("listaInsumos",listaInsumos);
		model.addAttribute("listaTipoInsumo", listaTiposInsumo);
		return "gestionInsumo";
	}
	
	@GetMapping("/gestionOrdenCompra")
	public String gestionOrdenCompra (Model model) {
		List<OrdenCompra> listaOrdenCompra = ordenCompraRepository.findAll();
		model.addAttribute("listaOrdenCompra", listaOrdenCompra);
		
		return "gestionOrdenCompra";
	}
}
 