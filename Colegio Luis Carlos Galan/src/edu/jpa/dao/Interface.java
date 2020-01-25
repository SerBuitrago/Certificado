package edu.jpa.dao;

import java.util.List;

/**
 * Implementación Interface Interface.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public interface Interface<T> {
	/* Listar */
	public List<T> list();

	/* Elemento PK */
	public <E> T find(E id);

	/* Insertar */
	public void insert(T o);

	/* Actualizar */
	public void update(T o);

	/* Eliminar */
	public void delete(T o);
}
