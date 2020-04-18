package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Ciudad
 *
 */
@Entity
@Table(name="CIUDADES", schema="PROYECTO")
public class Ciudad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CIU_ID")
	private Long id;
	
	@Column(name = "CIU_NOMBRE", length=50, nullable=false, unique=true)
	private String nombre;

	public Object setNombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

}
