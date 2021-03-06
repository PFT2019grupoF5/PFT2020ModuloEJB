package com.beans;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

import com.entities.Almacenamiento;
import com.entities.Movimiento;
import com.entities.Producto;
import com.exception.ServiciosException;

@Remote
public interface IMovimientosRemote {

	public void addMovimiento(Movimiento movimiento) throws ServiciosException;
	public List<Movimiento> getAllMovimientos() throws ServiciosException;
	public List<Movimiento> getMovimientosByDescripcion(String descripcion) throws ServiciosException;
	public Movimiento getMovimiento(Long id) throws ServiciosException;
	public void removeMovimiento(Long id) throws ServiciosException;
	public void updateMovimiento(Movimiento movimiento) throws ServiciosException;

	public List<Movimiento> getMovimientosEntreFecha(java.util.Date fecinicial, java.util.Date fecfinal) throws ServiciosException;
	public List<Movimiento> getMovimientosProductoAlmacenamiento(Producto producto, Almacenamiento almacenamiento) throws ServiciosException;
	
}