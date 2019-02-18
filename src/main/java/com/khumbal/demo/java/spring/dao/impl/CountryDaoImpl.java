package com.khumbal.demo.java.spring.dao.impl;

import com.khumbal.demo.java.spring.dao.utils.Hibernate3Dao;
import com.khumbal.demo.java.spring.model.Country;
import com.khumbal.demo.java.spring.dao.CountryDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl extends Hibernate3Dao<Country> implements CountryDao {

    public void save(Country country) {
        Session session = getSessionFactory().openSession();
        session.saveOrUpdate(country);
        session.flush();
    }

    public List<Country> findAll() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Country.class);
        return criteria.list();
    }

}
