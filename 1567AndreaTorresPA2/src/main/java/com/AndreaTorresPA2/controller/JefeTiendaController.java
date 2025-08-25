package com.AndreaTorresPA2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.AndreaTorresPA2.dao.JefeTiendaDAO;
import com.AndreaTorresPA2.model.JefeTienda;

/**
* Servlet implementation class JefeTiendaController
*/

@WebServlet("/jefeTienda")
public class JefeTiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JefeTiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @throws IOException 
     * @throws ServletException 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		
		switch (opcion){
		
		case "mostrarGestionJefeTienda" :{
			mostrarGestionJefeTienda(request,response);
			break;
		}
			case "buscarJefeTienda":{
				try {
					buscarJefeTienda(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			case "eliminar" :{
				try {
					eliminar(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			case "editar" :{
				try {
					editar(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		/*
		 * asi se coloca para luego se cambie con el try/multicatch 
		case "eliminar":{
			eliminar(request,response);
			break;
		} */
		
		
		
	}

	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		//llamamos a la func
		JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();		
		JefeTienda jefeTienda = jefeTiendaDAO.buscarxid(id);
		
		request.setAttribute("jefeTienda", jefeTienda);
		
		//Mandamos a gestionTienda
		String  paginaDestino = "/editarJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		//llamamos a la func
		JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();		
		jefeTiendaDAO.eliminar(id);
		
	   //Mandamos a gestionTienda
				String  paginaDestino = "/gestionJefeTienda.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
				response.sendRedirect("jefeTienda?opcionGet=buscarJefeTienda");
	
	}

	private void mostrarGestionJefeTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Mandamos a gestionTienda
				String  paginaDestino = "/gestionJefeTienda.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
				dispatcher.forward(request, response);
	}

	private void buscarJefeTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		
		JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
		List<JefeTienda>listarJefe  = jefeTiendaDAO.buscarJefe(apellidoPaterno, apellidoMaterno);
		request.setAttribute("listarjefe", listarJefe);
		
		//Mandamos a gestionTienda
		String  paginaDestino = "/gestionJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch(opcion) {
		case "mostrarNuevoJefe" :{
			mostrarNuevoJefe(request,response);
			break;
		}
		
		case "agregarJefes" :{
			try {
				agregarJefes(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		case "editarJefes":{
			try {
				editarJefes(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		}
		
	}

	private void editarJefes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String dni = request.getParameter("dni");
		
		JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
		jefeTiendaDAO.editarJefes(id, nombre, apellidoPaterno, apellidoMaterno, dni);
		
		//Mandamos a gestionTienda
		String  paginaDestino = "/editarJefeTienda.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);				
		dispatcher.forward(request, response);	

	}

	private void agregarJefes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String dni = request.getParameter("dni");
		
		JefeTiendaDAO jefeTiendaDAO = new JefeTiendaDAO();
		jefeTiendaDAO.agregarJefes(nombre, apellidoPaterno, apellidoMaterno, dni);
		
		//Mandamos a gestionTienda
				String  paginaDestino = "/gestionJefeTienda.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
				dispatcher.forward(request, response);
		
	}

	private void mostrarNuevoJefe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Mandamos a NuevoJefeTienda
				String  paginaDestino = "/nuevoJefeTienda.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
				dispatcher.forward(request, response);	
	}

	

    
}
