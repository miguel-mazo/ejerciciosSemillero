package com.hbt.semillero.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.VehiculoDTO;
import com.hbt.semillero.entidades.Vehiculo;
import com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal;

/**
 * Componente que expone servicios rest.
 * 
 * @author Johnny Soto
 *
 */
@Path("/ConsultasRest")
public class ConsultasRest {

	@EJB
	private IConsultasEjbLocal consultaEJB;

	/**
	 * Consulta las marcas existentes en el sistema.
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas() {
		return consultaEJB.consultarMarcasExistentes();
	}

	/**
	 * Consulta las marcas existentes en el sistema.
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarLineasPorMarca")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineasPorMarca(@QueryParam("idMarca") Long idMarca) {
		return consultaEJB.consultarLineasPorMarca(idMarca);
	}
	
	/**
	 * Consulta los vehículos de la Marca seleccionada por el usuario
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarMarcaLinea")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VehiculoDTO> consultarMarcaLinea(@QueryParam("idLinea") Long idMarca, @QueryParam("idLinea") Long idLinea) {
		return consultaEJB.consultarMarcaLinea(idMarca, idLinea);
	}
	

	/**
	 * Consulta las personas que cumplan con los criterios ingresados
	 * 
	 * @param tipoID
	 * @param numID
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam("tipoID") String tipoID, @QueryParam("numID") String numID) {
		return consultaEJB.consultarPersonas(tipoID, numID);
	}

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * 
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO persona) {
		return consultaEJB.crearPersona(persona);
	}
	
	/**
	 * Edita los atributos del vehiculo seleccionado
	 * @param vehiculo
	 */
	
	@PUT
	@Path("/editarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarVehiculo(VehiculoDTO vehiculo) {
		consultaEJB.editarVehiculo(vehiculo);
	}
	
	/**
	 * Borra el vehiculo seleccionado
	 * @param idVehiculo
	 */
	@DELETE
	@Path("/borrarVehiculo/{idVehiculo}")
	@Produces(MediaType.APPLICATION_JSON)
	public void borrarVehiculo(@PathParam("idVehiculo") Long idVehiculo) {
		consultaEJB.borrarVehiculo(idVehiculo);
	}
	
	/**
	 * Consulta el vehiculo que cumpla con el criterio ingresado
	 * @param idVehiculo
	 * @return
	 */
	@GET
	@Path("/consultarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehiculo consultarVehiculo(@QueryParam("idVehiculo") Long idVehiculo) {
		return consultaEJB.consultarVehiculo(idVehiculo);
	}
}
