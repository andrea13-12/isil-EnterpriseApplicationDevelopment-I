package com.isilErpSpring.key;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleOrdenCompraKey implements Serializable {
	//esto es por la tabla de muchos a muchos que estamos realizado 
	//estamos creando una clase que sera la llave de esta entidad que esta compuesta x dos valores
	@Column(name="idInsumo")
	private int idInsumo;
	
	@Column(name="IdOrdenCompra")
	private int idOrdenCompra;

	public int getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	public int getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(int idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}
	
	
}
