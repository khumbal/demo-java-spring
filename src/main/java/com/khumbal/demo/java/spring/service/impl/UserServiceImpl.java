package com.khumbal.demo.java.spring.service.impl;

import com.khumbal.demo.java.spring.dao.UserDao;
import com.khumbal.demo.java.spring.model.User;
import com.khumbal.demo.java.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void register(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<User> findAll() {
        return userDao.findAll();
    }
}
