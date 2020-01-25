package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Implementación Clase Acudiente.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name="Acudiente.findAll", query="SELECT a FROM Acudiente a")
public class Acudiente implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int documento;

	private String direccion;
	private String nombre;
	private String telefono;

	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@OneToMany(mappedBy="acudiente")
	private List<Estudiante> estudiantes;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Acudiente() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public String toString() {
		return "ID Acudiente: "+documento +", Nombre: "+nombre;	
	}
	
	/**
	 * Metodo que retorna los estudiantes a cargo tiene este acudiente.
	 * @return una cadena con los estudiantes.
	 */
	public String estudiantes() {
		String aux="";
		for(Estudiante e: estudiantes) {
			aux += ""+e;
		}
		return aux;
	}
	
	
	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setAcudiente(this);
		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setAcudiente(null);
		return estudiante;
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}