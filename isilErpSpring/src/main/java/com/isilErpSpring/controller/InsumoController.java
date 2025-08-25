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

import com.isilErpSpring.entity.Insumo;
import com.isilErpSpring.entity.Proveedor;
import com.isilErpSpring.entity.TipoInsumo;
import com.isilErpSpring.repository.InsumoRepository;
import com.isilErpSpring.repository.ProveedorRepository;
import com.isilErpSpring.repository.TipoInsumoRepository;


@Controller
@RequestMapping("/insumo")
//para cargar un formulario hay que tener un objeto (insumo en este caso)
public class InsumoController {

	@Autowired
	InsumoRepository insumoRepository;
	
	@Autowired
	TipoInsumoRepository tipoInsumoRepository;
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@RequestMapping("/buscar")
	public String buscar(@RequestParam("tipo")int idTipo, Model model) {
		//creamos un obj de tipo insumo porq solo tiene el id
		TipoInsumo tipoInsumo = new TipoInsumo();
		tipoInsumo.setId(idTipo);
		
		List<Insumo> listaInsumos = insumoRepository.findbyTipo(tipoInsumo);
		model.addAttribute("listaInsumos", listaInsumos);

		List<TipoInsumo> listaTipoInsumos = tipoInsumoRepository.findAll();
		model.addAttribute("listaTipoInsumos", listaTipoInsumos);
		
		
		return "gestionInsumo";
		
	}
	
	@GetMapping("eliminar/{id}")
	public String eliminar(@PathVariable("id")int idInsumo) {
		insumoRepository.deleteByid(idInsumo);
		return "gestionInsumo";
	}
	
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
		List<TipoInsumo> listaTipoInsumos = tipoInsumoRepository.findAll();
		model.addAttribute("listaTipoInsumos", listaTipoInsumos);
		
		List<Proveedor> listaProveedores = proveedorRepository.findAll();
		model.addAttribute("listaProveedores", listaProveedores);
		
		Insumo insumo = new Insumo();
		model.addAttribute("insumo", insumo);
		
		return "nuevoInsumo";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("insumo")Insumo insumo, Model model) {
		//Antes de grabar se debe realizar las validaciones necesarias para que el obj no este dublicado 
		//para este ejemp, estoy asumiendo que no se va a dar
		
		insumoRepository.save(insumo);
		
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);

		List<TipoInsumo> listaTipoInsumos = tipoInsumoRepository.findAll();
		model.addAttribute("listaTipoInsumos", listaTipoInsumos);
		return "gestionInsumo";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		Insumo insumo = insumoRepository.findById(id);
		model.addAttribute("insumo", insumo);
		
		List<TipoInsumo> listaTipoInsumos = tipoInsumoRepository.findAll();
		model.addAttribute("listaTipoInsumos", listaTipoInsumos);
		
		List<Proveedor> listaProveedores = proveedorRepository.findAll();
		model.addAttribute("listaProveedores", listaProveedores);
		
		return "editarInsumo";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@ModelAttribute("insumo")Insumo insumo) {
		Insumo insumoBD = insumoRepository.findById(insumo.getId());
		//Aqui el insumo bd tiene toda la informacion del insumo actualizar, sin cambios		
		//vamos a actualizar los datos del insumo que hemos obtenido 
		insumoBD.setNombre(insumo.getNombre());
		insumoBD.setTipo(insumo.getTipo());
		insumoBD.setStock(insumo.getStock());
		insumoBD.setStockMinimo(insumo.getStockMinimo());
		insumoBD.setProveedor(insumo.getProveedor());
		insumoBD.setEstado(insumo.getEstado());
		
		insumoRepository.save(insumoBD);
		
		//como ya tenemos metodos que realizan todo el codigo(gestion insumo) 
		//lo direcciono a ese oara ya no copiar todo el code
		return "redirect:/home/gestionInsumo";
	}
}
