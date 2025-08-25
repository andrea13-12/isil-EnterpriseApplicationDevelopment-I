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
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
		
		case "validacionUsuario" :{
			try {
				validacionUsuario(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		case "mostrarLogin" :{
			mostrarLogin(request,response);
			break;
		}
		}

	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//lo mandamos a al index
		String paginaDestino = "/index.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);	
	}

	private void validacionUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		UsuarioDao usuarioDao = new UsuarioDao();
		boolean esUsuario=usuarioDao.validarUsuario(correo, password);
		if(esUsuario) {
			//lo mandamos a la pagina principal
			String paginaDestino = "/principal.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			dispatcher.forward(request, response);
			
		}else {
		    String mensaje = "Correo electronico incorrecto, intentelo de nuevo";
		    request.setAttribute("mensaje", mensaje);
		    
		    //lo mandamos a al index
		    String paginaDestino = "/index.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			dispatcher.forward(request, response);
		}
	}

}
