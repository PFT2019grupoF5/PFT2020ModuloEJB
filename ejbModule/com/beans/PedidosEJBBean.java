package com.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Movimiento;
import com.entities.Pedido;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class PedidosEJBBean
 */
@Stateless
public class PedidosEJBBean implements IPedidosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addPedido(Pedido pedido) throws ServiciosException {
		try{
			em.persist(pedido);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el pedido");
		}
	}

	@Override
	public List<Pedido> getAllPedidos() throws ServiciosException {
		try{		
			TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p",Pedido.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de pedidos");
		}
	}

	@Override
	public Pedido getPedido(Long id) throws ServiciosException {
		try{
			Pedido pedido = em.find(Pedido.class, id);
			return pedido;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el pedido");
		}
	}

	@Override
	public void removePedido(Long id) throws ServiciosException {
		try{
			Pedido pedido = em.find(Pedido.class, id);
			em.remove(pedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el pedido");
		}
	}

	@Override
	public void updatePedido(Pedido pedido) throws ServiciosException {
		try{
			em.merge(pedido);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el pedido");
		}	
	}

	@Override
	public List<Pedido> getPedidosEntreFechas(String fechaDesde, String fechaHasta) throws ServiciosException {
		TypedQuery<Pedido> query = null;
		try{
			try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
	            Date fDesde = dateFormat.parse(fechaDesde);
	            Date fHasta = dateFormat.parse(fechaHasta);
				query = em.createQuery("SELECT p FROM Pedido p WHERE p.PED_FECHA BETWEEN :fechaDesde AND :fechaHasta",Pedido.class) 
					.setParameter("fechaDesde", fDesde)
					.setParameter("fechaHasta", fHasta);
	        } catch (ParseException ex) {
	        }
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener reporte de pedidos entre fechas");
		}
	}


	
}

