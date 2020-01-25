package edu.jpa.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * Implementación Clase Conexion.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
public class Conexion<T> {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private Class<T> c;
	private static EntityManager em = null;

	///////////////////////////////////////////////////////
	/// Cosntructor ///////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Constructor vacio.
	 */
	public Conexion() {
		em = this.getEm();
	}

	/**
	 * Constructor que recibe la clase conexion.
	 * 
	 * @param c representa la clase.
	 */
	public Conexion(Class<T> c) {
		em = this.getEm();
		this.c = c;
	}

	///////////////////////////////////////////////////////
	/// Setters ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	public void setC(Class<T> c) {
		this.c = c;
	}

	///////////////////////////////////////////////////////
	/// Getters ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	public static EntityManager getEm() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");
			em = emf.createEntityManager();
		}
		return em;
	}

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que trae el elemento mediante su PK.
	 * 
	 * @param <E> representa el tipo de dato.
	 * @param id  representa la PK.
	 * @return el elemento generico E.
	 */
	public <E> T find(E id) {
		T object = (T) em.find(c, id);
		return object;
	}

	/**
	 * Metodo que lista todos los datos de la tabla.
	 * 
	 * @return represeta la lista.
	 */
	public List<T> list() {
		TypedQuery<T> consulta = em.createNamedQuery(c.getSimpleName() + ".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}

	/**
	 * Metodo que inserta un elemento a la tabla.
	 * 
	 * @param o representa el elemento a insertar.
	 */
	public void insert(T o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
	}

	/**
	 * Metodo que actualiza un elemento de la tabla.
	 * 
	 * @param o representa el elemento a actualizar.
	 */
	public void update(T o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
	}

	/**
	 * Metodo que elimina un elemento en la tabla.
	 * 
	 * @param o representa el elemento.
	 */
	public void delete(T o) {
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
	}

	/**
	 * Metodo que trae un elemento depediendo de un fila y su valor.
	 * 
	 * @param <E>        representa el valor.
	 * @param fieldName  representa la fila.
	 * @param fieldValue representa el valor fila.
	 * @return el elemento encontrado.
	 */
	public <E> T findByField(String fieldName, E fieldValue) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(c);
		Root<T> root = criteriaQuery.from(c);
		criteriaQuery.select(root);

		ParameterExpression<E> params = criteriaBuilder.parameter((Class<E>) Object.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get(fieldName), params));

		TypedQuery<T> query = (TypedQuery<T>) em.createQuery(criteriaQuery);
		query.setParameter(params, (E) fieldValue);

		List<T> queryResult = query.getResultList();

		T returnObject = null;

		if (!queryResult.isEmpty()) {
			returnObject = queryResult.get(0);
		}
		return returnObject;
	}

	/**
	 * Metodo que lista los elementos depediendo de un fila y su valor.
	 * 
	 * @param <E>        representa el valor.
	 * @param fieldName  representa la fila.
	 * @param fieldValue representa el valor fila.
	 * @return la lista.
	 */
	public <E> List<T> findByFieldList(String fieldName, E fieldValue) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(c);
		Root<T> root = criteriaQuery.from(c);
		criteriaQuery.select(root);

		ParameterExpression<E> params = criteriaBuilder.parameter((Class<E>) Object.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get(fieldName), params));

		TypedQuery<T> query = (TypedQuery<T>) em.createQuery(criteriaQuery);
		query.setParameter(params, (E) fieldValue);

		List<T> queryResult = query.getResultList();
		return queryResult;
	}
}
