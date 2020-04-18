package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.enumerated.tipoPerfil;

/**
 * Entity implementation class for Entity: Perfil
 *
 */
@Entity
@Table(name="PERFILES", schema="PROYECTO")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PERF_CODIGO")
	private Long id;
	
	@Column(name = "PERF_NOMBRE", length = 50, nullable=false, unique=true)
	@Enumerated(value = EnumType.STRING)
	private tipoPerfil tipoperfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public tipoPerfil getPerfil() {
		return tipoperfil;
	}

	public void setPerfil(tipoPerfil tipoperfil) {
		this.tipoperfil = tipoperfil;
	}

	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(tipoPerfil tipoperfil) {
		super();
		this.tipoperfil = tipoperfil;
	}

}
