package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Producto;
import com.exception.ServiciosException;

@Remote
public interface IProductosRemote {

	public void addProducto(Producto producto) throws ServiciosException;
	public List<Producto> getAllProductos() throws ServiciosException;
	public List<Producto> getProductosByNombre(String nombre) throws ServiciosException;
	public Producto getProducto(Long id) throws ServiciosException;
	public void removeProducto(Long id) throws ServiciosException;
	public void updateProducto(Producto producto) throws ServiciosException;
	
}