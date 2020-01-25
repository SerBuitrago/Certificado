package edu.jpa.dao;

import edu.jpa.entity.Tecnica;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase TecnicaDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class TecnicaDao 
	   extends Conexion<Tecnica> 
	   implements Interface<Tecnica> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public TecnicaDao() {
		super(Tecnica.class);
	}

}
