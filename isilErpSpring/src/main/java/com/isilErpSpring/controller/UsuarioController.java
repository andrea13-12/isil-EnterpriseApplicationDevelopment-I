package com.isilErpSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilErpSpring.entity.Usuario;
import com.isilErpSpring.repository.UsuarioRepository;

@Controller 
//Permite poder colocar un nombre pequeño al controllador
@RequestMapping("/usuario")
public class UsuarioController {
	//Permite trabajar el repositorio como si fuera un obj

	@Autowired 
	UsuarioRepository usuarioRepository;
	//Al controlador se puede realizar 3 Tipos de llamadas
	//1. Post Mapping  Cuando la llamada es x metodo POST y se trabaja con obj
	//2. Get Mapping, Cuando la llamada es x metodo GET o URL.
	//3. Request Mapping, se utiliza para obtener un o mas datos del formulario de manera individual (aguanta POST Y GET)
	
	@RequestMapping("/validarUsuario") //todos los metodos que son llamados por una pagina debe ser colocados como String
	public String validarUsuario(@RequestParam("correo")String correo, @RequestParam("password")String password) {
		Usuario usuario = usuarioRepository.findByCorreoAndPassword(correo, password);
		if (usuario !=null) {
			return "principal";
		}else {
			return "index";
		}
	}

	@GetMapping("/registrar")
	public String registrar() {
		return "registrateAqui";
	}
	
	//MODEL se usa para dejar un dato en memoria 
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("correo")String correo, @RequestParam("password")String password, Model model) {
		Usuario usuarioBD = usuarioRepository.findByCorreo(correo);
		//si no se ha encontrado ningun correo en la bd, lo manda a registrar
		if(usuarioBD!=null) {
			String mesanje = "El correo ya se encuentra registrado en el sistema";
			model.addAttribute("mensaje", mesanje);
			return "registrateAqui";
		}
		
		Usuario usuario = new Usuario();
		usuario.setCorreo(correo);
		usuario.setPassword(password);
		usuario.setEstado("Activo");
		usuarioRepository.save(usuario);
		return "index";
	}
	
}
