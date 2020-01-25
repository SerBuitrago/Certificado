package edu.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Implementación Clase NotaEmbeddable.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Embeddable
public class NotaEmbeddable implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	private int asignatura_profesor;
	private int estudiante_grado;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public NotaEmbeddable() {
	}
	
	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + asignatura_profesor;
		result = prime * result + estudiante_grado;
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
		NotaEmbeddable other = (NotaEmbeddable) obj;
		if (asignatura_profesor != other.asignatura_profesor)
			return false;
		if (estudiante_grado != other.estudiante_grado)
			return false;
		return true;
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public int getAsignatura_profesor() {
		return asignatura_profesor;
	}

	public void setAsignatura_profesor(int asignatura_profesor) {
		this.asignatura_profesor = asignatura_profesor;
	}

	public int getEstudiante_grado() {
		return estudiante_grado;
	}

	public void setEstudiante_grado(int estudiante_grado) {
		this.estudiante_grado = estudiante_grado;
	}

}
