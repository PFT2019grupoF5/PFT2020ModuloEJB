package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Producto;
import com.exception.ServiciosException;

@Local
public interface IProductosLocal {

	public void addProducto(Producto producto) throws ServiciosException;
	public List<Producto> getAllProductos() throws ServiciosException;
	public List<Producto> getProductosByNombre(String nombre) throws ServiciosException;
	public Producto getProducto(Long id) throws ServiciosException;
	public void removeProducto(Long id) throws ServiciosException;
	public void updateProducto(Producto producto) throws ServiciosException;
	
}