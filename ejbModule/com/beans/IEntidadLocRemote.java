package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.EntidadLoc;
import com.exception.ServiciosException;

@Remote
public interface IEntidadLocRemote {

	public void addEntidadLoc(EntidadLoc localEnt) throws ServiciosException;
	public List<EntidadLoc> getAllEntidadesLoc() throws ServiciosException;
	public List<EntidadLoc> getEntidadesLocByNombre(String nombre) throws ServiciosException;
	public List<EntidadLoc> getEntidadesLocByCodigo(int codigo) throws ServiciosException;
	public EntidadLoc getEntidadLoc(Long id) throws ServiciosException;
	public void removeEntidadLoc(Long id) throws ServiciosException;
	public void updateEntidadLoc(EntidadLoc local) throws ServiciosException;
	
}