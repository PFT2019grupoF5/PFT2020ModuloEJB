package com.beans;

import java.util.List;
import javax.ejb.Local;

import com.entities.Perfil;
import com.exception.ServiciosException;

@Local
public interface IPerfilesLocal {

	public void addPerfil(Perfil perfil) throws ServiciosException;
	public List<Perfil> getAllPerfiles() throws ServiciosException;
	//public List<Perfil> getPerfilesByNombre(String nombre) throws ServiciosException;
	public Perfil getPerfil(Long id) throws ServiciosException;
	public void removePerfil(Long id) throws ServiciosException;
	public void updatePerfil(Perfil perfil) throws ServiciosException;
	
}