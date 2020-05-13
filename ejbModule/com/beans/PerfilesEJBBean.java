package com.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import com.entities.Perfil;
import com.enumerated.tipoPerfil;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class PerfilesEJBBean
 */
@Stateless
public class PerfilesEJBBean implements IPerfilesRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addPerfil(Perfil perfil) throws ServiciosException {
		try{
			em.persist(perfil);
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el perfil");
		}
	}

	@Override
	public List<Perfil> getAllPerfiles() throws ServiciosException {
		try{		
			TypedQuery<Perfil> query = em.createQuery("SELECT p FROM Perfil p",Perfil.class); 
			return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener lista de perfiles");
		}
	}

	@Override
	public List<Perfil> getPerfilesByNombre(String txtTipoPerfil) throws ServiciosException {
		try{
			TypedQuery<Perfil> query = em.createQuery("SELECT p FROM Perfil p WHERE p.tipoPerfil LIKE :tipoPerfil",Perfil.class)
    				.setParameter("tipoPerfil", tipoPerfil.valueOf(txtTipoPerfil)); 
    		return query.getResultList();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo obtener el perfil de nombre " + txtTipoPerfil);
    	}
	}

	@Override
	public Perfil getPerfil(Long id) throws ServiciosException {
		try{
			Perfil perfil = em.find(Perfil.class, id);
			return perfil;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo encontrar el perfil");
		}
	}

	@Override
	public void removePerfil(Long id) throws ServiciosException {
		try{
			Perfil perfil = em.find(Perfil.class, id);
			em.remove(perfil);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el perfil");
		}
	}

	@Override
	public void updatePerfil(Perfil perfil) throws ServiciosException {
		try{
			em.merge(perfil);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el perfil");
		}	
	}

}
