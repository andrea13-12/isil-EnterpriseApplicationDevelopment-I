package com.AndreaTorres1567.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AndreaTorres1567.model.Sucursal;

public class SucursalDAO {

	private String url;
	private Connection conexion;

	public SucursalDAO() {
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=1567;user=sa;password=sa";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Sucursal> buscarSucursal(String direccion) throws SQLException {
		List<Sucursal> listaSucursales = new ArrayList<>();
		String setenciaSQL = "select * from Sucursal where direccion like '%" + direccion + "%'";
		Statement stmt = this.conexion.createStatement();
		ResultSet rs = stmt.executeQuery(setenciaSQL);
		while (rs.next()) {
			int idBD = rs.getInt(1);
			String nombreBD = rs.getString(2);
			String direccionBD = rs.getString(3);
			String estadoBD = rs.getString(4);

			Sucursal objSucursal = new Sucursal();
			objSucursal.setId(idBD);
			objSucursal.setNombre(nombreBD);
			objSucursal.setDireccion(direccionBD);
			objSucursal.setEstado(estadoBD);
			listaSucursales.add(objSucursal);
		}
		rs.close();
		this.conexion.close();
		return listaSucursales;
	}
}
