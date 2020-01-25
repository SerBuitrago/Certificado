package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Implementación Clase EstudianteEmbeddable.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Embeddable
public class EstudianteEmbeddable implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	private int documento;
	private int codigo;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public EstudianteEmbeddable() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstudianteEmbeddable)) {
			return false;
		}
		EstudianteEmbeddable castOther = (EstudianteEmbeddable) other;
		return (this.documento == castOther.documento) && (this.codigo == castOther.codigo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.documento;
		hash = hash * prime + this.codigo;

		return hash;
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public int getDocumento() {
		return this.documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}