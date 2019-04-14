package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hbt.semillero.entidades.Linea;

public class VehiculoDTO implements Serializable {
	
	//Identificador del vehículo
	private Long idVehiculo;

	//Modelo
	private int modelo;

	//Placa
	private String placa;

	//Línea
	private LineaDTO linea;

	//Método que obtiene el valor de la propiedad idVehiculo
	public Long getIdVehiculo() {
		return idVehiculo;
	}

	//Método que asigna el valor de la propiedad idVehiculo
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	//Método que obtiene el valor de la propiedad modelo
	public int getModelo() {
		return modelo;
	}
	
	//Método que asigna el valor de la propiedad modelo
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	//Método que obtiene el valor de la propiedad placa
	public String getPlaca() {
		return placa;
	}

	//Método que asigna el valor de la propiedad placa
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	//Método que obtiene el valor de la propiedad linea
	public LineaDTO getLinea() {
		return linea;
	}

	//Método que asigna el valor de la propiedad linea
	public void setLinea(LineaDTO linea) {
		this.linea = linea;
	}
	
}
