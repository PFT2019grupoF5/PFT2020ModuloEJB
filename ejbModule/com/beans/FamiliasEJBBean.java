package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Familia;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class FamiliasEJBBean
 */
@Stateless
public class FamiliasEJBBean implements IFamiliasRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addFamilia(Familia familia) throws ServiciosException {
		try{
			em.persist(familia);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear la familia");
		}
	}

	@Override
	public List<Familia> getAllFamilias() throws ServiciosException {
		try{		
			TypedQuery<Familia> query = em.createQuery("SELECT f FROM Familia f",Familia.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de familias");
		}
	}

	@Override
	public List<Familia> getFamiliasByNombre(String nombre) throws ServiciosException {
		try{
			TypedQuery<Familia> query = em.createQuery("SELECT f FROM Familia f WHERE f.nombre LIKE :nombre",Familia.class)
    				.setParameter("nombre", nombre); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener la familia de nombre " + nombre);
    	}
	}

	@Override
	public Familia getFamilia(Long id) throws ServiciosException {
		try{
			Familia familia = em.find(Familia.class, id);
			return familia;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar la familia");
		}
	}

	@Override
	public void removeFamilia(Long id) throws ServiciosException {
		try{
			Familia familia = em.find(Familia.class, id);
			em.remove(familia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar la familia");
		}
	}

	@Override
	public void updateFamilia(Familia familia) throws ServiciosException {
		try{
			em.merge(familia);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar la familia");
		}	
	}

}

