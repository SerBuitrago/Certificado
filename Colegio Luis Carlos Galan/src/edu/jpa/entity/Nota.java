package edu.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

/**
 * Implementación Clase Nota.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")
public class Nota implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotaEmbeddable id;

	private String jornada;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nota")
	private Date nota;

	private float trabajo_equipo, trabajo_individual, evaluacion, actitudinal, definitiva;
	private String descripcion;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Nota() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public String toString() {
		return "";//asignatura.getAsignatura() + " " + asignatura.getProfesor() + " Año: " + nota + " Nota " + definitiva;
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public NotaEmbeddable getId() {
		return id;
	}

	public void setId(NotaEmbeddable id) {
		this.id = id;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public Date getNota() {
		return nota;
	}

	public void setNota(Date nota) {
		this.nota = nota;
	}

	public float getTrabajo_equipo() {
		return trabajo_equipo;
	}

	public void setTrabajo_equipo(float trabajo_equipo) {
		this.trabajo_equipo = trabajo_equipo;
	}

	public float getTrabajo_individual() {
		return trabajo_individual;
	}

	public void setTrabajo_individual(float trabajo_individual) {
		this.trabajo_individual = trabajo_individual;
	}

	public float getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(float evaluacion) {
		this.evaluacion = evaluacion;
	}

	public float getActitudinal() {
		return actitudinal;
	}

	public void setActitudinal(float actitudinal) {
		this.actitudinal = actitudinal;
	}

	public float getDefinitiva() {
		return definitiva;
	}

	public void setDefinitiva(float definitiva) {
		this.definitiva = definitiva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
