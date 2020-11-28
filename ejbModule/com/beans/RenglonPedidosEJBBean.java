package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.RenglonPedido;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class RenglonPedidosEJBBean
 */
@Stateless
public class RenglonPedidosEJBBean implements IRenglonPedidosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addRenglonPedido(RenglonPedido renglonPedido) throws ServiciosException {
		try{
			em.persist(renglonPedido);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el renglonPedido");
		}
	}

	@Override
	public List<RenglonPedido> getAllRenglonPedidos() throws ServiciosException {
		try{		
			TypedQuery<RenglonPedido> query = em.createQuery("SELECT p FROM RenglonPedido p",RenglonPedido.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de renglonPedidos");
		}
	}

	@Override
	public RenglonPedido getRenglonPedido(Long id) throws ServiciosException {
		try{
			RenglonPedido renglonPedido = em.find(RenglonPedido.class, id);
			return renglonPedido;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el renglonPedido");
		}
	}

	@Override
	public void removeRenglonPedido(Long id) throws ServiciosException {
		try{
			RenglonPedido renglonPedido = em.find(RenglonPedido.class, id);
			em.remove(renglonPedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el renglonPedido");
		}
	}

	@Override
	public void updateRenglonPedido(RenglonPedido renglonPedido) throws ServiciosException {
		try{
			em.merge(renglonPedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el renglonPedido");
		}	
	}

}

