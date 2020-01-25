package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * Implementación Clase Estudiante.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	
	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Column(name="tipo_documento")
	private String tipo;
	
	@EmbeddedId
	private EstudianteEmbeddable id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion")
	private Date expedicion;

	private String nombre;
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date nacimiento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_matricula")
	private Date matricula;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date salida;

	private String email;
	private String nacionalidad;
	
	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@ManyToOne
	@JoinColumn(name="id_acudiente")
	private Acudiente acudiente;
	
	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Estudiante() {
	}
	
	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	public String toString() {
		return "Documento: "+id.getDocumento() +", Nombre: "+nombre+" "+apellido;	
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////
	public EstudianteEmbeddable getId() {
		return this.id;
	}

	public void setId(EstudianteEmbeddable id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpedicion() {
		return this.expedicion;
	}

	public void setExpedicion(Date expedicion) {
		this.expedicion = expedicion;
	}

	public Date getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Date matricula) {
		this.matricula= matricula;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Date getSalida() {
		return this.salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Acudiente getAcudiente() {
		return this.acudiente;
	}

	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}
}