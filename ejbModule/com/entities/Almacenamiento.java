package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Almacenamiento
 *
 */
//Comentario
@Entity
@Table(name="ALMACENAMIENTOS")
public class Almacenamiento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ALMA_ID")
	private Long id;
	
	@Column(name = "ALMA_VOLUMEN", nullable =  false)
	private int volumen;

	@Column(name = "ALMA_DESCRIPCION", length=250)
	private String nombre;
	
	@Column(name = "ALMA_COSTOOP", nullable = false, columnDefinition = "FLOAT(5,2)")
	private double costoop;

	@Column(name = "ALMA_CAPESTIBA", nullable = false, columnDefinition = "FLOAT(5,2)")
	private double capestiba;

	@Column(name = "ALMA_CAPPESO", nullable = false, columnDefinition = "FLOAT(5,2)")
	private double cappeso;

	@ManyToOne(optional=false)
	@JoinColumn(name = "ALMA_LOC_ID")
	private EntidadLoc entidadLoc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCostoop() {
		return costoop;
	}

	public void setCostoop(double costoop) {
		this.costoop = costoop;
	}

	public double getCapestiba() {
		return capestiba;
	}

	public void setCapestiba(double capestiba) {
		this.capestiba = capestiba;
	}

	public double getCappeso() {
		return cappeso;
	}

	public void setCappeso(double cappeso) {
		this.cappeso = cappeso;
	}

	public EntidadLoc getEntidadLoc() {
		return entidadLoc;
	}

	public void setEntidadLoc(EntidadLoc entidadLoc) {
		this.entidadLoc = entidadLoc;
	}

	public Almacenamiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacenamiento(int volumen, String nombre, double costoop, double capestiba, double cappeso, EntidadLoc entidadLoc) {
		super();
		this.volumen = volumen;
		this.nombre = nombre;
		this.costoop = costoop;
		this.capestiba = capestiba;
		this.cappeso = cappeso;
		this.entidadLoc = entidadLoc;
	}

	
}
