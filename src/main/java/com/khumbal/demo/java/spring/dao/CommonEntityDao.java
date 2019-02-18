package com.khumbal.demo.java.spring.dao;

import com.khumbal.demo.java.spring.model.base.BaseEntity;

import java.io.Serializable;

/**
 * Common interface for CRUD operation
 * 
 * @author phongsiris
 * 
 * @param <T>
 */
public interface CommonEntityDao<T extends BaseEntity> extends Serializable{

	/**
	 * find object by ID
	 * 
	 * @param id
	 */
	public T findById(Long id);

	/**
	 * persist
	 * 
	 * @param obj
	 */
	public void persist(T obj);

	/**
	 * implie of using re-attach to session
	 * 
	 * @param obj
	 */
	public void update(T obj);

	/**
	 * Force persisting object to database and return a new merged object
	 * 
	 * @param obj
	 */
	public T merge(T obj);

	/**
	 * remove object from database
	 * 
	 * @param id
	 */
	public void removeById(Long id);

	/**
	 * remove object from database
	 * 
	 * @param id
	 */
	public void remove(Object id);

	/**
	 * ensure objects are saved to database
	 * 
	 */
	public void flush();
}
