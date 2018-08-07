package net.nexsource.demo.java.spring.dao.utils;

public interface PersistanceUtils{

	public void attach(Object o);

	public void detach(Object o);

	public void clearSession();

	public void flush();

	public void flushAndClearSession();

	public void refresh(Object o);
}