package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * Implementación Clase AsignaturaProfesor.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@Table(name="asignatura_profesor")
@NamedQuery(name="AsignaturaProfesor.findAll", query="SELECT a FROM AsignaturaProfesor a")
public class AsignaturaProfesor implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;

	@Temporal(TemporalType.DATE)
	private Date anio;

	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name="id_asignatura")
	private Asignatura asignatura;

	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public AsignaturaProfesor() {
	}
	
	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public String toString() {
		return "ID Asignatura: "+asignatura.getId() +", Profesor: "+profesor+", Año: "+anio;	
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}