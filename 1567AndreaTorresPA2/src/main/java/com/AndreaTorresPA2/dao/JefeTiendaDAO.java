package com.AndreaTorresPA2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AndreaTorresPA2.model.JefeTienda;



public class JefeTiendaDAO {

	private String url;
	private Connection conexion;
	public JefeTiendaDAO() {
		this.url = "jdbc:mysql://localhost/miSistemaBD?user=root&password="; //nombre de la instancia de la bd |databaseName|//cambiar esto con tu bd
		try {
			/*Cargamos el driver de sql server */
			Class.forName("com.mysql.cj.jdbc.Driver");
			 /*Aqui establecemos la conexion*/
			this.conexion = DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public List<JefeTienda> buscarJefe(String apellidoPaterno, String apellidoMaterno) throws SQLException{
		List<JefeTienda>listarJefe = new ArrayList<JefeTienda>();
		String sentenciaSQL = "select * from JefeTienda where apellidoPaterno like ? and apellidoMaterno like ?";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentenciaSQL);
		pstmt.setString(1, "%" + apellidoPaterno + "%");
		pstmt.setString(2, "%" + apellidoMaterno + "%");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int idBD = rs.getInt(1);
			String nombreBD = rs.getString(2);
			String apellidoPaternoBD = rs.getString(3);
			String apellidoMaternoBD = rs.getString(4);
			String dniBD = rs.getString(5);
			
			JefeTienda objJefeTienda = new JefeTienda();
			objJefeTienda.setId(idBD);
			objJefeTienda.setNombre(nombreBD);
			objJefeTienda.setApellidoPaterno(apellidoPaternoBD);
			objJefeTienda.setApellidoMaterno(apellidoMaternoBD);
			objJefeTienda.setDni(dniBD);

			listarJefe.add(objJefeTienda);

		}
		rs.close();
		this.conexion.close();
		return listarJefe;
	}
	
	public void agregarJefes(String nombre, String apellidoPaterno, String apellidoMaterno, String dni) throws SQLException {
		String sentenciaSQL = "insert into JefeTienda(nombre,apellidoPaterno, apellidoMaterno, dni) values(?,?,?,?)";
		PreparedStatement pstmp = this.conexion.prepareStatement(sentenciaSQL);
		
		pstmp.setString(1, nombre);
		pstmp.setString(2, apellidoPaterno);
		pstmp.setString(3, apellidoMaterno);
		pstmp.setString(4, dni);
		
		pstmp.execute();
		this.conexion.close();
	}
	
	public void editarJefes (int id, String nombre, String apellidoPaterno, String apellidoMaterno, String dni) throws SQLException {
		String sentenciaSQL = "update JefeTienda set nombre=?, apellidoPaterno=?, apellidoMaterno=?, dni=? where id=?";
		PreparedStatement pstmp = this.conexion.prepareStatement(sentenciaSQL);
		pstmp.setString(1, nombre);
		pstmp.setString(2, apellidoPaterno);
		pstmp.setString(3, apellidoMaterno);
		pstmp.setString(4, dni);
		pstmp.setInt(5, id);
		
		pstmp.execute();
		this.conexion.close();
		
	}
	
	public void eliminar(int id) throws SQLException {	
		String sentenciaSQL = "delete from JefeTienda where id = " + id;
		Statement stmt = this.conexion.createStatement();
		stmt.execute(sentenciaSQL);
		this.conexion.close();
	}
	
	public JefeTienda buscarxid(int id) throws SQLException {
		JefeTienda jefeTienda = null;
	    String sentenciaSQL = "select * from JefeTienda where id=?";
	    PreparedStatement pstmt = this.conexion.prepareStatement(sentenciaSQL);
	    pstmt.setInt(1, id); 
	    ResultSet rs = pstmt.executeQuery();
	    
		while (rs.next()) {
			int idBD = rs.getInt(1);
			String nombreBD = rs.getString(2);
			String apellidoPaternoBD = rs.getString(3);
			String apellidoMaternoBD = rs.getString(4);
			String dniBD = rs.getString(5);
			
			jefeTienda = new JefeTienda();
			jefeTienda.setId(idBD);
			jefeTienda.setNombre(nombreBD);
			jefeTienda.setApellidoPaterno(apellidoPaternoBD);
			jefeTienda.setApellidoMaterno(apellidoMaternoBD);
			jefeTienda.setDni(dniBD);
		}
		
		rs.close();
		this.conexion.close();
		return jefeTienda;
		
	}
	
}
