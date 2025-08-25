package com.isilErpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilErpSpring.entity.Proveedor;
import com.isilErpSpring.repository.ProveedorRepository;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@RequestMapping("/buscar")
	public String buscar(@RequestParam("razonSocial")String razonSocial, Model model) {
		List<Proveedor> listaProveedores = proveedorRepository.findByRazonSocialContains(razonSocial);
		model.addAttribute("listaProveedores", listaProveedores);
		return "gestionProveedor";
	
	}
	//MODEL = Clase de objeto que convierte a un atributo
	
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("proveedor", proveedor);
		return "nuevoProveedor";
	}
	
	//para traer un dato que esta como object se usa MODELATTRIBUTE
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("proveedor")Proveedor proveedor, Model model) {
		Proveedor proveedorBD = proveedorRepository.findByRuc(proveedor.getRuc());
		//si no exite un proveedor lo guardamos
		if(proveedorBD == null) {
			proveedor.setEstado("Activo");
			proveedorRepository.save(proveedor);
			return "gestionProveedor";
		} else {
			String mensaje = "El proveedor ya se encuentra registrado en el sistema";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("proveedor",proveedor);
			return "nuevoProveedor";
		}
	}
	
	//PathVariable = viene de url 
	//ModelAtribute = quiero traer un obj
	//RequestParam = 
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id")int id) {
		proveedorRepository.deleteById(id);
		return "gestionProveedor";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		Proveedor proveedor = proveedorRepository.finById(id);
		model.addAttribute("proveedor", proveedor);		
		
		return "editarProveedor";
	}
	
	@PostMapping("/actualizar")
	public String actualizar (@ModelAttribute("proveedor")Proveedor proveedor, Model model) {
		Proveedor proveedorBD = proveedorRepository.finById(proveedor.getId());
		proveedorBD.setRuc(proveedor.getRuc());
		proveedorBD.setRazonSocial(proveedor.getRazonSocial());
		proveedorBD.setDireccion(proveedor.getDireccion());
		proveedorBD.setEstado(proveedor.getEstado());
		
		proveedorRepository.save(proveedorBD);
		
		return "gestionProveedor";
	}
	
}
