package edu.jpa.dao;

import java.util.List;

import javax.persistence.Query;

import edu.jpa.entity.Certificado;
import edu.jpa.entity.EstudianteGrado;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase CertificadoDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class CertificadoDao extends Conexion<Certificado> implements Interface<Certificado> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public CertificadoDao() {
		super(Certificado.class);
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que consulta el certificado de un estudiante.
	 * 
	 * @param estudiante representa el documento del estudiante.
	 * @param grado      representa el grado del estudiante.
	 * @return el certificado encontrado.
	 */
	public Certificado certificado(int estudiante, String grado) {
		EstudianteGradoDao dao = new EstudianteGradoDao();
		EstudianteGrado eg = dao.certificado(estudiante, grado);
		System.out.print("Estudiante Grado: " + eg);
		if (eg != null) {
			Query query = getEm().createQuery(
					"Select c from Certificado c where c.id.estudiante_grado='" + eg.getId().getCodigo() + "'");
			List<?> results = query.getResultList();
			return (!results.isEmpty()) ? (Certificado) results.get(0) : null;
		} else {
			return null;
		}
	}
}
