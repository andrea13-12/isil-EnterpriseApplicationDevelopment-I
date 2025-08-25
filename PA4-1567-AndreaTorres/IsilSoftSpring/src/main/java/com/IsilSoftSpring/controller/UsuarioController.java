package com.IsilSoftSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.IsilSoftSpring.entity.Usuario;
import com.IsilSoftSpring.repository.UsuarioRepository;

@Controller 
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/validarUsuario")
	public String validarUsuario (@RequestParam("correo")String correo, @RequestParam("password")String password) {
		Usuario usuario = usuarioRepository.findByCorreoAndPassword(correo, password);
		if (usuario !=null) {
			return "principal";
		}else {
			return "index";
		}
	}
	
	
}
