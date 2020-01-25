package edu.jpa.dao;

import edu.jpa.entity.Grado;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase GradoDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class GradoDao 
	   extends Conexion<Grado> 
	   implements Interface<Grado> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public GradoDao() {
		super(Grado.class);
	}
}
