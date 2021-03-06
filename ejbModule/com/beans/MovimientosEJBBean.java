package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Almacenamiento;
import com.entities.Movimiento;
import com.entities.Producto;
import com.exception.ServiciosException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
	public List<Movimiento> getMovimientosProductoAlmacenamiento(Producto producto, Almacenamiento almacenamiento) throws ServiciosException {
		try{
			// Long productoID = producto.getId();
			// Long almacenamientoID =almacenamiento.getId();
			
			TypedQuery<Movimiento> query = em.createQuery("SELECT m FROM Movimiento m WHERE m.producto LIKE :producto AND m.almacenamiento LIKE :almacenamiento",Movimiento.class)
    				.setParameter("producto", producto) 
					.setParameter("almacenamiento", almacenamiento); 
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
	public List<Movimiento> getMovimientosEntreFecha(java.util.Date fechaIni, java.util.Date fechaFin) throws ServiciosException {
		try{
			
			//try {
				//SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
			    //java.util.Date fechaIni = null;
		        //java.util.Date fechaFin = null;
		        
				//fechaIni = formato.parse(fecini);
	            //fechaFin = formato.parse(fecfin);
	              
				TypedQuery<Movimiento> query = em.createQuery("SELECT m FROM Movimiento m WHERE m.MOV_FECHA BETWEEN :fechaIni AND :fechaFin", Movimiento.class)
	    				.setParameter("fechaIni", fechaIni) 
						.setParameter("fechaFin", fechaFin);
				
	    		return query.getResultList();
			
			//}catch(PersistenceException | ParseException e){
			//	throw new ServiciosException("No se pudo convertir la fecha, debe estar en formato dd/mm/aaaa");
	    	//} 
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudieron obtener Movimientos entre fechas " + fechaIni + " y " + fechaFin);
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

