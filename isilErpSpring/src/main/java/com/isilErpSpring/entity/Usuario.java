package com.isilErpSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//importamos jakartaEntity
@Entity
public class Usuario {
	//identificar cual o cuales son los PK "@Id"
	//se tiene que escribir EXTAMENTE IGUAL A LA BD 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String correo;
	private String password;
	private String estado;
	
	//creamos las propiedades 
	//lick derecho -> source -> getters and setters 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
}
