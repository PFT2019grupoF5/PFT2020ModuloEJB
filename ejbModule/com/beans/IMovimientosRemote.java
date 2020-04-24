package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Movimiento;
import com.exception.ServiciosException;

@Remote
public interface IMovimientosRemote {

	public void addMovimiento(Movimiento movimiento) throws ServiciosException;
	public List<Movimiento> getAllMovimientos() throws ServiciosException;
	public List<Movimiento> getMovimientosByDescripcion(String descripcion) throws ServiciosException;
	public Movimiento getMovimiento(Long id) throws ServiciosException;
	public void removeMovimiento(Long id) throws ServiciosException;
	public void updateMovimiento(Movimiento movimiento) throws ServiciosException;
	
}