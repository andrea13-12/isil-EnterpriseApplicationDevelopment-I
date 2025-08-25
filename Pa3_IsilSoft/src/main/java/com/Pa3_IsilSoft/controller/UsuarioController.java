package com.Pa3_IsilSoft.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.Pa3_IsilSoft.dao.UsuarioDao;

/**
 * Servlet implementation class UsuarioController
 */

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcionGet");
		switch(opcion) {
			case "mostrarCrearUsuario" :{
				mostrarCrearUsuario(request,response);
				break;
			}
			
			case "mostrarRecuperarContrasena" :{
				mostrarRecuperarContrasena(request,response);
				break;
			}
			
			case "recuperarContrasena" :{
				try {
					recuperarContrasena(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	private void recuperarContrasena(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("correo");
		UsuarioDao usuarioDao = new UsuarioDao();
		String password = usuarioDao.buscarUsuarioxCorreo(correo);
		if(password==null) {
			String mensaje="No se encuentra el correo";
			request.setAttribute("mensaje", mensaje);
		}else {
			request.setAttribute("password", password);
		}
		//lo mandamos a recuperar contrasña
		String paginaDestino = "/recuperarContrasena.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

	private void mostrarRecuperarContrasena(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Mandamos a Recperar Contrasna
		String paginaDestino = "/recuperarContrasena.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

	private void mostrarCrearUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Mandamos a Nuevo Usuario
		String paginaDestino = "/nuevoUsuario.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
		case "registroUsuario" :{
			try {
				registroUsuario(request,response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		}
	}

	private void registroUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apePaterno= request.getParameter("apePaterno");
		String apeMaterno = request.getParameter("apeMaterno");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String password= request.getParameter("password");
		UsuarioDao usuarioDao = new UsuarioDao();
		boolean existe= usuarioDao.validarSiExisteUsuario(correo);
		if(existe) {
			//mensaje
			String mensaje="El Usuario ya se encuentra registrado";
			request.setAttribute("mensaje", mensaje);
			
			//Mandamos a Nuevo Usuario
			String paginaDestino = "/nuevoUsuario.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			dispatcher.forward(request, response);
		}
		else {
			UsuarioDao usuarioDao1 = new UsuarioDao();
			usuarioDao1.registrarUsuario(nombre, apePaterno, apeMaterno, direccion,correo, password);
			
			//Lo mandamos al Index 
			String paginaDestino = "/index.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			dispatcher.forward(request, response);
		}
	
	}

}
