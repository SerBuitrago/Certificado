package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Implementación Clase Tecnica.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name="Tecnica.findAll", query="SELECT t FROM Tecnica t")
public class Tecnica implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String tecnica;
	
	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	@OneToMany(mappedBy="tecnica")
	private List<Asignatura> asignaturas;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Tecnica() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que muestra las materias de esta tecnica.
	 * @return representa la cadena con las materias.
	 */
	public String materias() {
		String aux ="";
		for(Asignatura a: asignaturas) {
			aux+="\n"+a;
		}
		return aux;	
	}
	
	public String toString() {
		return "ID Tecnica: "+tecnica;	
	}
	
	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public String getTecnica() {
		
		return this.tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
}