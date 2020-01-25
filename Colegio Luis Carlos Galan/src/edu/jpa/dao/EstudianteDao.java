package edu.jpa.dao;

import javax.persistence.Query;
import java.util.List;

import edu.jpa.entity.Estudiante;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase EstudianteDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class EstudianteDao extends Conexion<Estudiante> implements Interface<Estudiante> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public EstudianteDao() {
		super(Estudiante.class);
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	/**
	 * Metodo que verifica un DNI y el tipo.
	 * 
	 * @param <T>   representa el tipo de dato DNI.
	 * @param valor representa el valor DNI.
	 * @param tipo  representa el tipo de DNI.
	 * @return el estudiante encontrado. <br>
	 *         0 -> Cedula Ciudania. <br>
	 *         1 -> Codigo Estudiante. <br>
	 *         2 -> Tarjeta Identidad.
	 */
	public <T> Estudiante estudiante(T valor, byte tipo) {
		return (tipo == 0) ? findDocumento(valor, "CC")
				: ((tipo == 1) ? findCodigo(valor) : ((tipo == 2) ? findDocumento(valor, "TI") : null));
	}

	/**
	 * Metodo que consulta un estudiante por su documento.
	 * 
	 * @param <T>       representa el tipo de dato documento.
	 * @param documento representa el documento identidad.
	 * @return el estudiante encontrado.
	 */
	public <T> Estudiante findDocumento(T documento) {
		Query query = getEm().createQuery("Select e from Estudiante e where e.id.documento=" + documento);
		List<?> results = query.getResultList();
		return (!results.isEmpty()) ? (Estudiante) results.get(0) : null;
	}

	/**
	 * Metodo que consulta un estudiante por su documento y tipo de documento.
	 * 
	 * @param <T>       representa el tipo de dato documento.
	 * @param documento representa el documento identidad.
	 * @param tipo      representa el tipo documento.
	 * @return el estudiante encontrado.
	 */
	public <T, U> Estudiante findDocumento(T documento, U tipo) {
		Estudiante e = findDocumento(documento);
		if (e != null && e.getTipo() !=null  && tipo !=null) {
			if (e.getTipo().equals(tipo)) {
				return e;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Metodo que consulta un estudiante por su codigo estudiante.
	 * 
	 * @param <T>    representa el tipo de dato del codigo.
	 * @param codigo representa el codigo.
	 * @return e el estudiante encontrado.
	 */
	public <T> Estudiante findCodigo(T codigo) {
		Query query = getEm().createQuery("Select e from Estudiante e where e.id.codigo=" + codigo);
		List<?> results = query.getResultList();
		return (!results.isEmpty()) ? (Estudiante) results.get(0) : null;
	}
}
