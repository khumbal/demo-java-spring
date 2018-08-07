package net.nexsource.demo.java.spring.dao.utils;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernatePersistanceUtils extends Hibernate3Dao implements PersistanceUtils {

	public static final String ATTACH_UPDATE = "update", ATTACH_LOCK = "lock";

	//private SessionFactory sessionFactory;
	private String attachStrategy; // lock or update
	
	public HibernatePersistanceUtils(){
		this.attachStrategy = HibernatePersistanceUtils.ATTACH_UPDATE;
	}

	public HibernatePersistanceUtils(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void refresh(Object o){
		getCurrentSession().refresh(o);
	}

	public void attach(Object o){
		if(attachStrategy.equalsIgnoreCase(HibernatePersistanceUtils.ATTACH_UPDATE)){
			//			// attach object to session
			//			if (!sessionFactory.getCurrentSession().contains(o)) {
			getCurrentSession().update(o);
			//			}
		}else if(attachStrategy.equalsIgnoreCase(HibernatePersistanceUtils.ATTACH_LOCK)){
			getCurrentSession().lock(o, LockMode.NONE);
		}
	}

	public void detach(Object o){
		getCurrentSession().evict(o);
	}

	public String getAttachStrategy(){
		return attachStrategy;
	}

	public void setAttachStrategy(String attachStrategy){
		this.attachStrategy = attachStrategy;
	}

	public void flushAndClearSession(){
		flush();
		clearSession();
	}

	public void clearSession(){
		getCurrentSession().clear();
	}

	public void flush(){
		getCurrentSession().flush();
	}

	public static <T> T initializeAndUnproxy(T entity) {
		if (entity == null) {
			throw new
					NullPointerException("Entity passed for initialization is null");
		}

		Hibernate.initialize(entity);
		if (entity instanceof HibernateProxy) {
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
					.getImplementation();
		}
		return entity;
	}
}
