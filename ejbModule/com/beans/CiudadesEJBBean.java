package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Ciudad;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class CiudadesEJBBean
 */
@Stateless
public class CiudadesEJBBean implements ICiudadesRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addCiudad(Ciudad ciudad) throws ServiciosException {
		try{
			em.persist(ciudad);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la ciudad");
		}
	}

	@Override
	public List<Ciudad> getAllCiudades() throws ServiciosException {
		try{		
			TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c",Ciudad.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de ciudades");
		}
	}

	@Override
	public List<Ciudad> getCiudadesByNombre(String nombre) throws ServiciosException {
		try{
			TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre LIKE :nombre",Ciudad.class)
    				.setParameter("nombre", nombre); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener la ciudad de nombre " + nombre);
    	}
	}

	@Override
	public Ciudad getCiudad(Long id) throws ServiciosException {
		try{
			Ciudad ciudad = em.find(Ciudad.class, id);
			return ciudad;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar la ciudad");
		}
	}

	@Override
	public void removeCiudad(Long id) throws ServiciosException {
		try{
			Ciudad ciudad = em.find(Ciudad.class, id);
			em.remove(ciudad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar la ciudad");
		}
	}

	@Override
	public void updateCiudad(Ciudad ciudad) throws ServiciosException {
		try{
			em.merge(ciudad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar la ciudad");
		}	
	}

}

