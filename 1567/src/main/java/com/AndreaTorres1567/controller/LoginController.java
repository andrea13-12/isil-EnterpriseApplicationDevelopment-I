package com.AndreaTorres1567.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.AndreaTorres1567.dao.UsuarioDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "validarSucursal":{
				try {
					validarSucursal(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void validarSucursal(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
		String paginaDestino;
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		UsuarioDAO usuarioDao = new UsuarioDAO();
		boolean esSucursal = usuarioDao.validarSucursal(correo,password);
		if (esSucursal) {
			paginaDestino = "/principal.jsp";
			
		}
		else {
			paginaDestino = "/index.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);	
	}

}
