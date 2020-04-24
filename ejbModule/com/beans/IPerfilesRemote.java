package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Perfil;
import com.exception.ServiciosException;

@Remote
public interface IPerfilesRemote {

	public void addPerfil(Perfil perfil) throws ServiciosException;
	public List<Perfil> getAllPerfiles() throws ServiciosException;
	public List<Perfil> getPerfilesByNombre(String nombre) throws ServiciosException;
	public Perfil getPerfil(Long id) throws ServiciosException;
	public void removePerfil(Long id) throws ServiciosException;
	public void updatePerfil(Perfil perfil) throws ServiciosException;
	
}