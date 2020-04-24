package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Ciudad;
import com.exception.ServiciosException;

@Remote
public interface ICiudadesRemote {

	public void addCiudad(Ciudad ciudad) throws ServiciosException;
	public List<Ciudad> getAllCiudades() throws ServiciosException;
	public List<Ciudad> getCiudadesByNombre(String nombre) throws ServiciosException;
	public Ciudad getCiudad(Long id) throws ServiciosException;
	public void removeCiudad(Long id) throws ServiciosException;
	public void updateCiudad(Ciudad ciudad) throws ServiciosException;
	
}