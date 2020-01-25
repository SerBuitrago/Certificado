package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * Implementación Clase Rector.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name = "Rector.findAll", query = "SELECT r FROM Rector r")
public class Rector implements Serializable {
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "documento_trabajador")
	private int documento;

	private String especializacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date ingreso;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_salida")
	private Date salida;

	///////////////////////////////////////////////////////
	/// Mapeo /////////////////////////////////////////////
	///////////////////////////////////////////////////////
	@OneToOne
	@JoinColumn(name = "documento_trabajador")
	private Trabajador trabajador;

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Rector() {
	}

	/**
	 * Constructor que recibe el documento rector..
	 */
	public Rector(int documento) {
		this.documento = documento;
	}
	
	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	public String toString() {
		return "ID Trabajador: "+documento +", Nombre: "+trabajador.getNombre() +" "+trabajador.getApellido();	
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

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
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

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
}