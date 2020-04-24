package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Usuario;
import com.exception.ServiciosException;



/**
 * Session Bean implementation class UsuariosEJBBean
 */
@Stateless
public class UsuariosEJBBean implements IUsuariosRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addUsuario(Usuario usuario) throws ServiciosException {
		try{
			em.persist(usuario);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario");
		}
	}

	@Override
	public List<Usuario> getAllUsuarios() throws ServiciosException {
		try{		
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u",Usuario.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de usuarios");
		}
	}

	@Override
	public List<Usuario> getUsuariosBynomAcceso(String nomAcceso) throws ServiciosException {
		try{
			
			System.out.print(nomAcceso);
			
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nomAcceso LIKE :nomAcceso",Usuario.class)
    				.setParameter("nomAcceso", nomAcceso); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el usuario de nomAcceso " + nomAcceso);
    	}
	}

	@Override
	public Usuario getUsuario(Long id) throws ServiciosException {
		try{
			Usuario usuario = em.find(Usuario.class, id);
			return usuario;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el usuario");
		}
	}

	@Override
	public void removeUsuario(Long id) throws ServiciosException {
		try{
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el usuario");
		}
	}

	@Override
	public void updateUsuario(Usuario usuario) throws ServiciosException {
		try{
			em.merge(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}	
	}


//  A AGREGAR
	
	@Override
	public Usuario getUnUsuarioBynomAcceso(String nomAcceso) throws ServiciosException {
		try{
			
			System.out.print(nomAcceso);
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nomAcceso LIKE :nomAcceso",Usuario.class)
    				.setParameter("nomAcceso", nomAcceso); 
    		return query.getSingleResult();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el usuario de nomAcceso " + nomAcceso);
    	}
	}



}

