package com.hbt.semillero.dto;

import java.io.Serializable;

//Se crea una clase de apoyo con los atributos de la clase Marca y sus respectivos setters y getters

public class MarcaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idMarca;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	
}
