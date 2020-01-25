package edu.jpa.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * Implementación Clase Certificado.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name="Certificado.findAll", query="SELECT c FROM Certificado c")
public class Certificado implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CertificadoEmbeddable id;
	
	private byte[] certificado;
	private String descripcion;
	
	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name="id_rector")
	private Rector rector;
	
	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Certificado() {	
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public String toString() {
		return "ID Estudiante: "+id.getEstudiante_grado() +", Rector: "+rector+", Año: "+id.getAnio();	
	}
	
	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public CertificadoEmbeddable getId() {
		return id;
	}

	public void setId(CertificadoEmbeddable id) {
		this.id = id;
	}

	public byte[] getCertificado() {
		return certificado;
	}

	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}

	public Rector getRector() {
		return rector;
	}

	public void setRector(Rector rector) {
		this.rector = rector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
