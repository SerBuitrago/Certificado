package edu.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * Implementación Clase Profesor.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@Entity
@NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
public class Profesor implements Serializable {

	///////////////////////////////////////////////////////
	/// Profesor //////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "documento_trabajador")
	private int documento;

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
	/// Constructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Profesor() {
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	public String toString() {
		return "Documento: " + documento + ", Nombre: " + trabajador.getNombre() + " "
				+ trabajador.getApellido();
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