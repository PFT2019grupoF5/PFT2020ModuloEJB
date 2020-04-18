package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="USUARIOS", schema="PROYECTO")
public class Usuario implements Serializable {
			
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "USU_CODIGO")
		private Long id;
		
		@Column(length=50,name = "USU_NOMBRE",nullable=false)
		private String nombre;
		
		@Column(length=50,name = "USU_APELLIDO",nullable=false)
		private String apellido;
		
		@Column(length=50,name = "USU_NOMACCESO",nullable=false)
		private String nomAcceso;
		
		@Column(length=16,name = "USU_CONTRASENA",nullable=false)
		private String contrasena;
		
		@Column(length=50,name = "USU_CORREO", nullable=false)
		private String correo;
		
		@ManyToOne (optional =  false)
		@JoinColumn(name = "USU_PERF_CODIGO",nullable=false)
		private Perfil perfil;

		public String setNombre;

		public String setApellido;

		public String setNomAcceso;

		public String setContrasena;

		public String setCorreo;

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

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getNomAcceso() {
			return nomAcceso;
		}

		public void setNomAcceso(String nomAcceso) {
			this.nomAcceso = nomAcceso;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}

		public Usuario() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Usuario(String nombre, String apellido, String nomAcceso, String contrasena, String correo,
				Perfil perfil) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.nomAcceso = nomAcceso;
			this.contrasena = contrasena;
			this.correo = correo;
			this.perfil = perfil;
		}

}
