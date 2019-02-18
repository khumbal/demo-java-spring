package com.khumbal.demo.java.spring.dao.impl;

import com.khumbal.demo.java.spring.dao.utils.Hibernate3Dao;
import com.khumbal.demo.java.spring.model.User;
import com.khumbal.demo.java.spring.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends Hibernate3Dao<User> implements UserDao {

    public void save(User user) {
        Session session = getSessionFactory().openSession();
        session.saveOrUpdate(user);
        session.flush();
    }

    public List<User> findAll() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

}
