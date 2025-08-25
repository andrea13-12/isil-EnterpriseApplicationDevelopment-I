package com.isilErpSpring.entity;

import com.isilErpSpring.key.DetalleOrdenCompraKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class DetalleOrdenCompra {
	
	@EmbeddedId
	private DetalleOrdenCompraKey id; //esto es una llave compuesta por eso no se coloca entity (otro @)
	private int Cantidad;
	private double precioUnitario;
	private double precioTotal;
	
	@ManyToOne
	@JoinColumn(name="idInsumo")
	private Insumo insumo;
	
	@ManyToOne
	@JoinColumn(name="idOrdenCompra")
	private OrdenCompra ordenCompra;

	public DetalleOrdenCompraKey getId() {
		return id;
	}

	public void setId(DetalleOrdenCompraKey id) {
		this.id = id;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	
	
}
