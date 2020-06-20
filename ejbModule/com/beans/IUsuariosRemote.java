package com.beans;

import java.util.List;
import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface IUsuariosRemote {

	public void addUsuario(Usuario usuario) throws ServiciosException;
	public List<Usuario> getAllUsuarios() throws ServiciosException;
	public List<Usuario> getUsuariosBynomAcceso(String nomAcceso) throws ServiciosException;
	public Usuario getUnUsuarioBynomAcceso(String nomAcceso) throws ServiciosException;
	public Usuario getUsuario(Long id) throws ServiciosException;
	public void removeUsuario(Long id) throws ServiciosException;
	public void updateUsuario(Usuario usuario) throws ServiciosException;
	boolean checkUser(String user, String pass) throws ServiciosException;
	Usuario getPassw(String pass) throws ServiciosException;
	
}