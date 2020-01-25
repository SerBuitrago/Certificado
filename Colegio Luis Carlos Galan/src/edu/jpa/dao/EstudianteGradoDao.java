package edu.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import edu.jpa.entity.EstudianteGrado;
import edu.jpa.entity.Grado;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase EstudianteGradoDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class EstudianteGradoDao extends Conexion<EstudianteGrado> implements Interface<EstudianteGrado> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public EstudianteGradoDao() {
		super(EstudianteGrado.class);
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que retorna los grados de un estudiante.
	 * 
	 * @param <T> representa el tipo de dato del documento.
	 * @param id  representa el documento del estudiante.
	 * @return una lista con los grados encontrados.
	 */
	public <T> List<Grado> cursados(T id) {
		Query query = getEm()
				.createQuery("SELECT eg.id.grado FROM EstudianteGrado eg WHERE eg.id.id_estudiante='" + id + "'");
		List<Grado> g = new ArrayList<Grado>();

		List<?> results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			g.add(new Grado(results.get(i).toString()));
		}
		return g;
	}

	/**
	 * Metodo que trae el estudiante con un grado y el documento.
	 * 
	 * @param documento representa el documento.
	 * @param grado     representa el grado del estduiante.
	 * @return el estudinate encontrado.
	 */
	public EstudianteGrado certificado(int documento, String grado) {
		Query query = getEm().createQuery("SELECT eg FROM EstudianteGrado eg WHERE eg.id.id_estudiante='" + documento
				+ "' AND eg.id.grado='" + grado + "'");
		List<?> results = query.getResultList();
		return (!results.isEmpty()) ? (EstudianteGrado) results.get(0) : null;
	}

}
