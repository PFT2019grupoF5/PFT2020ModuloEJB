package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Movimiento;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class MovimientosEJBBean
 */
@Stateless
public class MovimientosEJBBean implements IMovimientosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addMovimiento(Movimiento movimiento) throws ServiciosException {
		try{
			em.persist(movimiento);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el movimiento");
		}
	}

	@Override
	public List<Movimiento> getAllMovimientos() throws ServiciosException {
		try{		
			TypedQuery<Movimiento> query = em.createQuery("SELECT m FROM Movimiento m",Movimiento.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de movimientos");
		}
	}

	@Override
	public List<Movimiento> getMovimientosByDescripcion(String descripcion) throws ServiciosException {
		try{
			TypedQuery<Movimiento> query = em.createQuery("SELECT m FROM Movimiento m WHERE m.descripcion LIKE :descripcion",Movimiento.class)
    				.setParameter("descripcion", descripcion); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener Movimiento de descripcion " + descripcion);
    	}
	}

	@Override
	public Movimiento getMovimiento(Long id) throws ServiciosException {
		try{
			Movimiento movimiento = em.find(Movimiento.class, id);
			return movimiento;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el movimiento");
		}
	}

	@Override
	public void removeMovimiento(Long id) throws ServiciosException {
		try{
			Movimiento movimiento = em.find(Movimiento.class, id);
			em.remove(movimiento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el movimiento");
		}
	}

	@Override
	public void updateMovimiento(Movimiento movimiento) throws ServiciosException {
		try{
			em.merge(movimiento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el movimiento");
		}	
	}

}

