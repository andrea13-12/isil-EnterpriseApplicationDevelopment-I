package com.IsilSoftSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
    @GetMapping("/mostrarRecuperarContrasena")
	public String mostrarRecuperarContrasena() {
	        return "recuperarContrasena"; 
	 }
	
    @PostMapping("/actualizar")
    public String actualizarContrasena(@RequestParam("correo") String correo, @RequestParam("nuevaContrasena") String nuevaContrasena,
        @RequestParam("confirmarContrasena") String confirmarContrasena, Model model) {
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            model.addAttribute("error", "Las contraseñas no coinciden");
            return "recuperarContrasena";
        }

        Usuario usuario = usuarioRepository.findByCorreo(correo);

        if (usuario == null) {
            model.addAttribute("error", "No se encontró el correo");
            return "recuperarContrasena";
        }

        usuario.setPassword(nuevaContrasena);
        usuarioRepository.save(usuario);

        return "index";
    }


	 
}
