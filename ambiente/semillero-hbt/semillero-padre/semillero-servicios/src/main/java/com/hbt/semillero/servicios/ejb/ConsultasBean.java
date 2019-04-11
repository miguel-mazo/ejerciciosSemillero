package com.hbt.semillero.servicios.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

@Stateless
public class ConsultasBean implements IConsultasBeanLocal{

	//Objeto para realizar las consultas
	@PersistenceContext
	private EntityManager entityManager;
	
	
	//Método para consultar las marcas
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		 return entityManager.createQuery("Select ma FROM Marca ma").getResultList();		
	}
	
	
	//Método para consultar las líneas por medio del identificador de la marca
	public List<Linea> consultarLineas(Long idMarca){
		Query consulta = entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca");
		consulta.setParameter("idMarca", idMarca);
		return consulta.getResultList();
	}
	
	//Método para consultar personas por medio del tipo y número de identificación
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Persona> consultarPersona(String tipoId, String numId) {
		Query consulta = entityManager.createQuery("SELECT pr FROM Persona pr WHERE pr.persona.tipoIdentificacion=:tipoId AND pr.persona.numeroIdentificacion=:numId");
		consulta.setParameter("tipoIdentificacion", tipoId);
		consulta.setParameter("numeroIdentificacion", numId);
		return consulta.getResultList();		
	}
	
	//Método para ingresar una nueva persona
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.persist(persona);
		
		if(personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}
		
		if(personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);			
		}
	}
	
	//Método para editar una persona registrada
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void editarPersona(PersonaDTO personaDTO) {
		
		Persona persona = entityManager.find(Persona.class, personaDTO.getIdPersona());
		
		if(persona != null) {
			
			persona.setNombres(personaDTO.getNombres());
			persona.setApellidos(personaDTO.getApellidos());
			persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
			persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
			persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
			persona.setEdad(personaDTO.getEdad());
			
			entityManager.merge(persona);
			
			if(personaDTO.isComprador()) {
				Comprador comprador = new Comprador();
				comprador.setFechaAfiliacion(Calendar.getInstance());
				comprador.setPersona(persona);
				entityManager.merge(comprador);
			}
			
			if(personaDTO.isVendedor()) {
				Vendedor vendedor = new Vendedor();
				vendedor.setFechaIngreso(Calendar.getInstance());
				vendedor.setPersona(persona);
				entityManager.merge(vendedor);			
			}
			
		} else {
			
			ResultadoDTO retorno = new ResultadoDTO();
			retorno.setMensajeError("LA PERSONA NO EXISTE");
		}
		
	}
}
