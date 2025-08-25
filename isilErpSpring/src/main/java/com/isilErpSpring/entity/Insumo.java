package com.isilErpSpring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Insumo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idTipo")
	private TipoInsumo tipo;
	
	private int stock;
	private int stockMinimo;
	private String estado;
	
	//esta dice como es la relacion en la bd
		@ManyToOne
		//hay que decir como se van a relacionar
		@JoinColumn(name="idProveedor")
		//traemos a todo el objeto, no solo el id como muestra en la bd  
		private Proveedor proveedor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public TipoInsumo getTipo() {
		return tipo;
	}

	public void setTipo(TipoInsumo tipo) {
		this.tipo = tipo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	
}
