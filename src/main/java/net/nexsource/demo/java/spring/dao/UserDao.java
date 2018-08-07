package net.nexsource.demo.java.spring.dao;

import net.nexsource.demo.java.spring.model.User;

import java.util.List;

public interface UserDao {

    public void save(User user);
    public List<User> findAll();

}
