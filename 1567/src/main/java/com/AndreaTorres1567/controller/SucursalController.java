package com.AndreaTorres1567.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import com.AndreaTorres1567.dao.SucursalDAO;
import com.AndreaTorres1567.model.Sucursal;

/**
 * Servlet implementation class ProveedorController
 */
@WebServlet("/sucursal")

public class SucursalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SucursalController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch(opcion) {
			case "mostrarGestionSucursal":{
				mostrarGestionSucursal (request, response);
				break;
			}
			case "buscarSucursal": {
				try {
					buscarSucursal (request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private void buscarSucursal (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String direccion = request.getParameter("direccion");
		SucursalDAO sucursalDao = new SucursalDAO();
				List <Sucursal>listaSucursales = sucursalDao.buscarSucursal(direccion);
				request.setAttribute("listaSucursales", listaSucursales);
				String paginaDestino = "/gestionSucursales.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino );
				dispatcher.forward(request, response);	
		
	}
	
	private void mostrarGestionSucursal (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String paginaDestino = "/gestionSucursal.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
			dispatcher.forward(request, response);	
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
