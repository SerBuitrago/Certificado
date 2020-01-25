package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Implementación Clase Asignatura.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte id;

	private float actitudinal;
	private float evaluacion;
	private String nombre;

	@Column(name="trabajo_equipo")
	private float trabajoEquipo;

	@Column(name="trabajo_individual")
	private float trabajoIndividual;

	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name="id_tecnica")
	private Tecnica tecnica;

	@OneToMany(mappedBy="asignatura")
	private List<AsignaturaProfesor> profesores;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Asignatura() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	public String toString() {
		return "ID Asignatura: "+id +", Nombre: "+nombre+", Tecnica: "+tecnica.getTecnica();	
	}
	
	/**
	 * Trae todos los profesores que dictaron esta asignatura.
	 * @return una cadena con todos los profesores.
	 */
	public String profesores() {
		String aux="Profesores Dictaron "+nombre;
		for(AsignaturaProfesor ap: profesores) {
			aux+="\n "+ap;			
		}
		return aux;
	}

	public AsignaturaProfesor addAsignaturaProfesor(AsignaturaProfesor asignaturaProfesor) {
		getAsignaturaProfesors().add(asignaturaProfesor);
		asignaturaProfesor.setAsignatura(this);

		return asignaturaProfesor;
	}

	public AsignaturaProfesor removeAsignaturaProfesor(AsignaturaProfesor asignaturaProfesor) {
		getAsignaturaProfesors().remove(asignaturaProfesor);
		asignaturaProfesor.setAsignatura(null);

		return asignaturaProfesor;
	}
	
	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public List<AsignaturaProfesor> getAsignaturaProfesors() {
		return this.profesores;
	}

	public void setAsignaturaProfesors(List<AsignaturaProfesor> asignaturaProfesors) {
		this.profesores = asignaturaProfesors;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public float getActitudinal() {
		return actitudinal;
	}

	public void setActitudinal(float actitudinal) {
		this.actitudinal = actitudinal;
	}

	public float getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(float evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTrabajoEquipo() {
		return trabajoEquipo;
	}

	public void setTrabajoEquipo(float trabajoEquipo) {
		this.trabajoEquipo = trabajoEquipo;
	}

	public float getTrabajoIndividual() {
		return trabajoIndividual;
	}

	public void setTrabajoIndividual(float trabajoIndividual) {
		this.trabajoIndividual = trabajoIndividual;
	}

	public Tecnica getTecnica() {
		return tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}

	public List<AsignaturaProfesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<AsignaturaProfesor> profesores) {
		this.profesores = profesores;
	}
}