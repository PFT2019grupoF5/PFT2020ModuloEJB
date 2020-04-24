package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Almacenamiento;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class AlmacenamientosEJBBean
 */
@Stateless
public class AlmacenamientosEJBBean implements IAlmacenamientosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addAlmacenamiento(Almacenamiento almacenamiento) throws ServiciosException {
		try{
			em.persist(almacenamiento);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el almacenamiento");
		}
	}

	@Override
	public List<Almacenamiento> getAllAlmacenamientos() throws ServiciosException {
		try{		
			TypedQuery<Almacenamiento> query = em.createQuery("SELECT a FROM Almacenamiento a",Almacenamiento.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de almacenamientos");
		}
	}

	@Override
	public List<Almacenamiento> getAlmacenamientosByNombre(String nombre) throws ServiciosException {
		try{
			TypedQuery<Almacenamiento> query = em.createQuery("SELECT a FROM Almacenamiento a WHERE a.nombre LIKE :nombre",Almacenamiento.class)
    				.setParameter("nombre", nombre); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el almacenamiento de nombre " + nombre);
    	}
	}

	@Override
	public Almacenamiento getAlmacenamiento(Long id) throws ServiciosException {
		try{
			Almacenamiento almacenamiento = em.find(Almacenamiento.class, id);
			return almacenamiento;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el almacenamiento");
		}
	}

	@Override
	public void removeAlmacenamiento(Long id) throws ServiciosException {
		try{
			Almacenamiento almacenamiento = em.find(Almacenamiento.class, id);
			em.remove(almacenamiento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el almacenamiento");
		}
	}

	@Override
	public void updateAlmacenamiento(Almacenamiento almacenamiento) throws ServiciosException {
		try{
			em.merge(almacenamiento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el almacenamiento");
		}	
	}

}
