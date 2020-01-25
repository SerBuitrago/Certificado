package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * Implementación Clase Trabajador.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
public class Trabajador implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documento;

	@Column(name = "tipo_documento")
	private String tipo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expedicion")
	private Date expedicion;

	private String nombre;
	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date nacimiento;

	private String telefono;
	private String direccion;
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date ingreso;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_salida")
	private Date salida;
	
	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@OneToOne(mappedBy = "trabajador")
	private Profesor profesor;

	@OneToOne(mappedBy = "trabajador")
	private Rector rector;

	///////////////////////////////////////////////////////
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Trabajador() {	
	}
	
	/**
	 * Constructor que recibe el documento trabajador..
	 */
	public Trabajador(int documento) {
		this.documento=documento;
	}
	
	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	
	public String toString() {
		return "ID Trabajador: "+documento +", Nombre: "+nombre+apellido;	
	}
	
	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getExpedicion() {
		return expedicion;
	}

	public void setExpedicion(Date expedicion) {
		this.expedicion = expedicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Rector getRector() {
		return rector;
	}

	public void setRector(Rector rector) {
		this.rector = rector;
	}
}