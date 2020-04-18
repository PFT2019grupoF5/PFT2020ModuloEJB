package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerated.tipoLoc;

/**
 * Entity implementation class for Entity: Local
 *
 */
@Entity
@Table(name="LOCALES", schema="PROYECTO")
public class EntidadLoc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LOC_ID")
	private Long id;
	
	@Column(name = "LOC_CODIGO")
	private int codigo;
	
	@Column(name = "LOC_DESCRIP", length=50, nullable=false, unique=true)
	private String nombre;

	@Column(name = "LOC_DIRECCION", length=50)
	private String direccion;

	@Column(name = "LOC_TIPO", length = 50, nullable=false)
	@Enumerated(value = EnumType.STRING)
	private tipoLoc tipoloc;

	@ManyToOne (optional=false)
	@JoinColumn(name = "LOC_CIU_ID")
	private Ciudad ciudad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public tipoLoc getTipoloc() {
		return tipoloc;
	}

	public void setTipoloc(tipoLoc tipoloc) {
		this.tipoloc = tipoloc;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public EntidadLoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntidadLoc(int codigo, String nombre, String direccion, tipoLoc tipoloc, Ciudad ciudad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipoloc = tipoloc;
		this.ciudad = ciudad;
	}
	
}
