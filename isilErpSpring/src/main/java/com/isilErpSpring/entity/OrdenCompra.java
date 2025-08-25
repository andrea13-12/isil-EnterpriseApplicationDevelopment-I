package com.isilErpSpring.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date fecha; //import sql
	private String estado;
	private double montoTotal;
	private double montoSinIGV;
	private double montoIGV;
	
	@ManyToOne
	@JoinColumn(name="proveedor")
	private Proveedor proveedor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public double getMontoSinIGV() {
		return montoSinIGV;
	}

	public void setMontoSinIGV(double montoSinIGV) {
		this.montoSinIGV = montoSinIGV;
	}

	public double getMontoIGV() {
		return montoIGV;
	}

	public void setMontoIGV(double montoIGV) {
		this.montoIGV = montoIGV;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	

}
