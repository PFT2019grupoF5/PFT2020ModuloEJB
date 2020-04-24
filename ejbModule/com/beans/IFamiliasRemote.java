package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Familia;
import com.exception.ServiciosException;

@Remote
public interface IFamiliasRemote {

	public void addFamilia(Familia familia) throws ServiciosException;
	public List<Familia> getAllFamilias() throws ServiciosException;
	public List<Familia> getFamiliasByNombre(String nombre) throws ServiciosException;
	public Familia getFamilia(Long id) throws ServiciosException;
	public void removeFamilia(Long id) throws ServiciosException;
	public void updateFamilia(Familia familia) throws ServiciosException;
	
}