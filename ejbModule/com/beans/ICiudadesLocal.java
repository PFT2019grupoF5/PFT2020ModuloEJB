package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Ciudad;
import com.exception.ServiciosException;

@Local
public interface ICiudadesLocal {

	public void addCiudad(Ciudad ciudad) throws ServiciosException;
	public List<Ciudad> getAllCiudades() throws ServiciosException;
	public List<Ciudad> getCiudadesByNombre(String nombre) throws ServiciosException;
	public Ciudad getCiudad(Long id) throws ServiciosException;
	public void removeCiudad(Long id) throws ServiciosException;
	public void updateCiudad(Ciudad ciudad) throws ServiciosException;
	
}