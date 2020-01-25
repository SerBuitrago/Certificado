package edu.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Implementación Clase EstudianteGradoEmbeddable.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Embeddable
public class EstudianteGradoEmbeddable implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	private int codigo;
	private int id_estudiante;
	private String grado;

	@Temporal(TemporalType.DATE)
	private Date anio;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public EstudianteGradoEmbeddable() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((grado == null) ? 0 : grado.hashCode());
		result = prime * result + id_estudiante;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteGradoEmbeddable other = (EstudianteGradoEmbeddable) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (codigo != other.codigo)
			return false;
		if (grado == null) {
			if (other.grado != null)
				return false;
		} else if (!grado.equals(other.grado))
			return false;
		if (id_estudiante != other.id_estudiante)
			return false;
		return true;
	}
	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	
	
}
