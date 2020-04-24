package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Almacenamiento;
import com.exception.ServiciosException;

@Local
public interface IAlmacenamientosLocal {

	public void addAlmacenamiento(Almacenamiento almacenamiento) throws ServiciosException;
	public List<Almacenamiento> getAllAlmacenamientos() throws ServiciosException;
	//public List<Almacenamiento> getAlmacenamientosByNombre(String nombre) throws ServiciosException;
	public Almacenamiento getAlmacenamiento(Long id) throws ServiciosException;
	public void removeAlmacenamiento(Long id) throws ServiciosException;
	public void updateAlmacenamiento(Almacenamiento almacenamiento) throws ServiciosException;
	
}