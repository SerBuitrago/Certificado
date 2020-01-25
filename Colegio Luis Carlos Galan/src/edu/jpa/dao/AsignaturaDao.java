package edu.jpa.dao;

import edu.jpa.entity.Asignatura;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase AsignaturaDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class AsignaturaDao 
	   extends Conexion<Asignatura> 
       implements Interface<Asignatura> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public AsignaturaDao() {
		super(Asignatura.class);
	}
}
