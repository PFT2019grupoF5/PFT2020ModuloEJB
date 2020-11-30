package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Producto;
import com.exception.ServiciosException;


/**
 * Session Bean implementation class ProductosEJBBean
 */
@Stateless
public class ProductosEJBBean implements IProductosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addProducto(Producto producto) throws ServiciosException {
		try{
			em.persist(producto);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el producto");
		}
	}

	@Override
	public List<Producto> getAllProductos() throws ServiciosException {
		try{		
			TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p",Producto.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de productos");
		}
	}

	@Override
	public List<Producto> getProductosByNombre(String nombre) throws ServiciosException {
		try{
			TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre",Producto.class)
    				.setParameter("nombre", nombre); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el producto de nombre " + nombre);
    	}
	}

	@Override
	public Producto getProducto(Long id) throws ServiciosException {
		try{
			Producto producto = em.find(Producto.class, id);
			return producto;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el producto");
		}
	}

	@Override
	public void removeProducto(Long id) throws ServiciosException {
		try{
			Producto producto = em.find(Producto.class, id);
			em.remove(producto);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el producto");
		}
	}

	@Override
	public void updateProducto(Producto producto) throws ServiciosException {
		try{
			em.merge(producto);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el producto");
		}	
	}

	@Override
	public Boolean StocKsuficienteDeProducto(int cantidad, String nombreProducto) throws ServiciosException {
		try{
			TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.nombre LIKE :nombre",Producto.class)
    				.setParameter("nombre", nombreProducto); 
			return query.getResultList().get(0).getStkTotal() >= cantidad;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el producto de nombre " + nombreProducto);
		}
	}

}