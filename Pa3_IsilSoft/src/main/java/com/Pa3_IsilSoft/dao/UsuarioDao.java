package com.Pa3_IsilSoft.dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Pa3_IsilSoft.model.Usuario;

public class UsuarioDao {
	private String url; //Ruta o direccion de mi bd 
	private Connection conexion; //Conexion con la bd
	
	public UsuarioDao() {
		this.url = "jdbc:mysql://localhost/IsilSoft?user=root&password="; //nombre de la instancia de la bd |databaseName|//cambiar esto con tu bd
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String buscarUsuarioxCorreo(String correo) throws SQLException {
		String password=null;
		Usuario objUsuario = new Usuario();
		CallableStatement cStmt = this.conexion.prepareCall("{call buscarUsuarioxCorreo(?)}");
		cStmt.setString(1, correo);
		ResultSet rs = cStmt.executeQuery();
		while(rs.next()) {
			int idBD = rs.getInt(1);
			String nombreBD = rs.getString(2);
			String apePaternoBD = rs.getString(3);
			String apeMaternoBD = rs.getString(4);
			String direccionBD = rs.getString(5);
			String correoBD = rs.getString(6);
			String passwordBD = rs.getString(7);
			objUsuario.setId(idBD);
			objUsuario.setNombre(nombreBD);
			objUsuario.setApePaterno(apePaternoBD);
			objUsuario.setApeMaterno(apeMaternoBD);
			objUsuario.setDireccion(direccionBD);
			objUsuario.setCorreo(correoBD);
			objUsuario.setPassword(passwordBD);
		}
		rs.close();
		this.conexion.close();
		password = objUsuario.getPassword();
		return password;
	}
	
	public boolean validarSiExisteUsuario(String correo) throws SQLException {
		boolean existe=false;
		String sentenciaSQL="select*from Usuario where correo=?";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentenciaSQL);
		pstmt.setString(1, correo);
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			existe=true;
			break;
		}
		rs.close();
		this.conexion.close();
		return existe;
	}
	
	public boolean validarUsuario(String correo, String password) throws SQLException {
		boolean esUsuario = false; 
		String sentenciaSQL = "select * from Usuario where correo=? and password=?";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentenciaSQL);
		pstmt.setString(1, correo);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			esUsuario = true;
		}
		rs.close();
		this.conexion.close();
		return esUsuario;
	}
	
	public void registrarUsuario(String nombre, String apePaterno, String apeMaterno, String direccion,String correo, String password) throws SQLException {
		String sentenciaSQL = "insert into Usuario(nombre, apePaterno, apeMaterno, direccion, correo, password) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = this.conexion.prepareStatement(sentenciaSQL);
		pstm.setString(1, nombre);
		pstm.setString(2, apePaterno);
		pstm.setString(3, apeMaterno);
		pstm.setString(4, direccion);
		pstm.setString(5, correo);
		pstm.setString(6, password);
		pstm.execute();
		this.conexion.close();
	}
}
