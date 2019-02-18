package com.khumbal.demo.java.spring.service;

import com.khumbal.demo.java.spring.model.User;

import java.util.List;

public interface UserService {

    void register(User user);


    List<User> findAll();

}
