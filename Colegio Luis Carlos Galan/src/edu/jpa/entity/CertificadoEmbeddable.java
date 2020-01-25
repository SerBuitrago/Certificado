package edu.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Implementación Clase CertificadoEmbeddable.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Embeddable
public class CertificadoEmbeddable implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	private int estudiante_grado;

	@Temporal(TemporalType.DATE)
	private Date anio;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public CertificadoEmbeddable() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
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
		CertificadoEmbeddable other = (CertificadoEmbeddable) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (estudiante_grado != other.estudiante_grado)
			return false;
		return true;
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public int getEstudiante_grado() {
		return estudiante_grado;
	}

	public void setEstudiante_grado(int estudiante_grado) {
		this.estudiante_grado = estudiante_grado;
	}

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}
}
