package com.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Pedido;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class PedidosEJBBean
 */
@Stateless
@LocalBean
public class PedidosEJBBean implements IPedidosRemote{

	@PersistenceContext
	private EntityManager em;
	
	//@Override
	public void addPedido(Pedido pedido) throws ServiciosException {
		try{
			em.persist(pedido);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el pedido");
		}
	}

	//@Override
	public List<Pedido> getAllPedidos() throws ServiciosException {
		try{		
			TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p",Pedido.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de pedidos");
		}
	}

	//@Override
	public Pedido getPedido(Long id) throws ServiciosException {
		try{
			Pedido pedido = em.find(Pedido.class, id);
			return pedido;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el pedido");
		}
	}

	//@Override
	public void removePedido(Long id) throws ServiciosException {
		try{
			Pedido pedido = em.find(Pedido.class, id);
			em.remove(pedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el pedido");
		}
	}

	//@Override
	public void updatePedido(Pedido pedido) throws ServiciosException {
		try{
			System.out.println(pedido.getPedreccomentario());
			em.merge(pedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el pedido");
		}	
	}

}

