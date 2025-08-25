package com.AndreaTorres1567.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

	private String url; //Ruta o direccion de mi bd 
	private Connection conexion; //Conexion con la bd
	
	public UsuarioDAO() {
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=1567;user=sa;password=sa"; //nombre de la instancia de la bd |databaseName|//cambiar esto con tu bd
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

public boolean validarSucursal(String correo, String password) throws SQLException {
	String sentenciaSQL = "select * from Sucursal where correo= '" + correo + "' and password= '" + password + " ' ";
	Statement stmt = this.conexion.createStatement();
	ResultSet rs = stmt.executeQuery(sentenciaSQL);
	boolean esSucursal= false;
	// para ir registro por registro en el resultado del query 
	while(rs.next()) {
		esSucursal = true;
	}
	rs.close();
		this.conexion.close();
		return esSucursal; 
	
}
}