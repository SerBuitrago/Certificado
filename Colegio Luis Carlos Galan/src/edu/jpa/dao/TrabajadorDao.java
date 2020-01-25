package edu.jpa.dao;

import edu.jpa.entity.Trabajador;
import edu.jpa.util.Conexion;

/**
 * Implementación Clase TrabajadorDao.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class TrabajadorDao 
       extends Conexion<Trabajador> 
       implements Interface<Trabajador> {
	
	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	public TrabajadorDao() {
	  super(Trabajador.class);
	}
}
