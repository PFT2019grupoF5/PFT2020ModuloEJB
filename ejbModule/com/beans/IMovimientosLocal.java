package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Movimiento;
import com.exception.ServiciosException;

@Local
public interface IMovimientosLocal {

	public void addMovimiento(Movimiento movimiento) throws ServiciosException;
	public List<Movimiento> getAllMovimientos() throws ServiciosException;
	public Movimiento getMovimiento(Long id) throws ServiciosException;
	public void removeMovimiento(Long id) throws ServiciosException;
	public void updateMovimiento(Movimiento movimiento) throws ServiciosException;
	
}