package com.khumbal.demo.java.spring.dao;

import com.khumbal.demo.java.spring.model.User;

import java.util.List;

public interface UserDao {

    public void save(User user);
    public List<User> findAll();

}
