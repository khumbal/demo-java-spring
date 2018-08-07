package net.nexsource.demo.java.spring.service;

import net.nexsource.demo.java.spring.model.User;

import java.util.List;

public interface UserService {

    void register(User user);


    List<User> findAll();

}
