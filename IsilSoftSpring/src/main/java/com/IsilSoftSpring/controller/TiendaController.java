package com.IsilSoftSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.IsilSoftSpring.entity.Colaborador;
import com.IsilSoftSpring.entity.Tienda;
import com.IsilSoftSpring.repository.ColaboradorRepository;
import com.IsilSoftSpring.repository.TiendaRepository;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

	@Autowired
	TiendaRepository tiendaRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@RequestMapping("/buscar")
	public String buscar(@RequestParam("distrito")String distrito, Model model) {
		List<Tienda> listaTiendas = tiendaRepository.findByDistritoContains(distrito);
		model.addAttribute("listaTiendas", listaTiendas);
		
		return "gestionarTienda";
	}
	
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
	    Tienda tienda = new Tienda();
	    model.addAttribute("tienda", tienda);

	    tienda.setColaborador(new Colaborador());
	    model.addAttribute("listaColaborador", colaboradorRepository.findAll());
	    return "nuevaTienda";
	}

	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("tienda") Tienda tienda, Model model) {
	    tiendaRepository.save(tienda); // ✅ guarda sin restricciones

	    model.addAttribute("mensaje", "Tienda registrada con éxito.");

	    Tienda nuevaTienda = new Tienda();
	    nuevaTienda.setColaborador(new Colaborador());

	    model.addAttribute("tienda", nuevaTienda);
	    model.addAttribute("listaColaborador", colaboradorRepository.findAll());

	    return "nuevaTienda"; 
	}

}
