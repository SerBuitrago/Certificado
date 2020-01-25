package edu.jpa.dao;

import edu.jpa.entity.Acudiente;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase AcudienteDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class AcudienteDao 
	extends Conexion<Acudiente> 
    implements Interface<Acudiente> {

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public AcudienteDao() {
		super(Acudiente.class);
	}
}
