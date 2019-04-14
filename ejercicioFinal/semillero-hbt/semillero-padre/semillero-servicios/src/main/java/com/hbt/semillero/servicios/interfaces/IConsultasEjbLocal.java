package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.VehiculoDTO;
import com.hbt.semillero.entidades.Vehiculo;

/**
 * Expone los métodos del EJB ConsultasEJB
 * 
 * @author Johnny Soto
 *
 */
@Local
public interface IConsultasEjbLocal {

	/**
	 * Consulta las marcas existentes en el sistema.
	 * 
	 * @return
	 */
	public List<MarcaDTO> consultarMarcasExistentes();
	
	/**
	 * Consulta una lista de la línea seleccionada por el
	 * usuario.
	 */
	public List<VehiculoDTO> consultarMarcaLinea(Long idMarca, Long idLinea);
	
	/**
	 * Consulta una lista de todas líneas asociadas a una marca registrada en el
	 * sistema.
	 */
	public List<LineaDTO> consultarLineasPorMarca(Long idMarca);

	/**
	 * Consulta las personas que cumplan con los criterios ingresados.
	 * 
	 * @param tipoID
	 * @param numID
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas(String tipoID, String numID);

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * 
	 * @param personaDTO
	 * @return
	 */
	public ResultadoDTO crearPersona(PersonaDTO personaDTO);

	/**
	 * Edita los atributos del vehiculo seleccionado
	 * @param vehiculo
	 */
	public void editarVehiculo(VehiculoDTO vehiculo);

	/**
	 * Borra el vehiculo seleccionado
	 * @param idVehiculo
	 */
	public void borrarVehiculo(Long idVehiculo);
	
	/**
	 * Consulta el vehiculo que cumpla con el criterio ingresado
	 * @param idVehiculo
	 * @return
	 */
	Vehiculo consultarVehiculo(Long idVehiculo);

}
