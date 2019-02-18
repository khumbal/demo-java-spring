package com.khumbal.demo.java.spring.dao.utils;

import com.khumbal.demo.java.spring.model.base.BaseEntity;
import com.khumbal.demo.java.spring.dao.CommonEntityDao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

/**
 * Hibernate3 helper
 *
 * @author phongsiri
 *
 */
public abstract class Hibernate3Dao<T extends BaseEntity> implements CommonEntityDao<T> {

	protected final Logger logger = Logger.getLogger(this.getClass());
	protected final boolean debugEnabled = logger.isDebugEnabled();

	private Class<T> entityClass;
	protected SessionFactory sessionFactory;

	public Hibernate3Dao(){

	}

	public Hibernate3Dao(Class<T> clazz){
		this.entityClass = clazz;
	}

	protected Class<T> getEntityClass(){
		return entityClass;
	}

	public Session getCurrentSession(){
		return getSessionFactory() != null ? getSessionFactory().getCurrentSession() : null;
	}

	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(@Qualifier("sessionFactory") SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void detach(Object obj) throws HibernateException{
		getSessionFactory().getCurrentSession().evict(obj);
	}

	public <T>void detach(Collection<T> objects) throws HibernateException{
		for(T o : objects){
			detach(o);
		}
	}

	public void flush(){
		getCurrentSession().flush();
	}

	public void lock(Object o, LockMode mode) throws HibernateException{
		getCurrentSession().lock(o, mode);
	}

	public void attachUpdate(Object o) throws HibernateException{
		getCurrentSession().update(o);
	}

	//// CRUD
	public T findById(Long id){
		return (T) getCurrentSession().get(getEntityClass(), id);
	}

	public T merge(T obj){
		return (T) getCurrentSession().merge(obj);
	}

	public void persist(T obj){
		getCurrentSession().persist(obj);
	}

	public void remove(Object obj){
		getCurrentSession().delete(obj);
	}

	public void removeById(Long id){
		T obj = findById(id);
		remove(obj);
	}

	public void update(T obj){
		getCurrentSession().update(obj);
	}

}
