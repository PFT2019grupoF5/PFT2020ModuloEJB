package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.EntidadLoc;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class EntidadesLocEJBBean
 */
@Stateless
public class EntidadLocEJBBean implements IEntidadLocRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEntidadLoc(EntidadLoc localEnt) throws ServiciosException {
		try{
			em.persist(localEnt);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear localEnt");
		}
	}

	@Override
	public List<EntidadLoc> getAllEntidadesLoc() throws ServiciosException {
		try{		
			TypedQuery<EntidadLoc> query = em.createQuery("SELECT l FROM EntidadLoc l",EntidadLoc.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de localesEnt");
		}
	}

	@Override
	public List<EntidadLoc> getEntidadesLocByNombre(String nombre) throws ServiciosException {
		try{
			TypedQuery<EntidadLoc> query = em.createQuery("SELECT l FROM EntidadLoc l WHERE l.nombre LIKE :nombre",EntidadLoc.class)
    				.setParameter("nombre", nombre); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener localEnt de nombre " + nombre);
    	}
	}

	@Override
	public List<EntidadLoc> getEntidadesLocByCodigo(int codigo) throws ServiciosException {
		try{
			TypedQuery<EntidadLoc> query = em.createQuery("SELECT l FROM EntidadLoc l WHERE l.codigo LIKE :codigo",EntidadLoc.class)
    				.setParameter("codigo", codigo); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener localEnt de codigo " + codigo);
    	}
	}

	@Override
	public EntidadLoc getEntidadLoc(Long id) throws ServiciosException {
		try{
			EntidadLoc localEnt = em.find(EntidadLoc.class, id);
			return localEnt;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar localEnt");
		}
	}

	@Override
	public void removeEntidadLoc(Long id) throws ServiciosException {
		try{
			EntidadLoc localEnt = em.find(EntidadLoc.class, id);
			em.remove(localEnt);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar localEnt");
		}
	}

	@Override
	public void updateEntidadLoc(EntidadLoc localEnt) throws ServiciosException {
		try{
			em.merge(localEnt);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar localEnt");
		}	
	}

}

