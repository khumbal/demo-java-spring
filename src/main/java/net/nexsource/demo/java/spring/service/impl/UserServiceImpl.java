package net.nexsource.demo.java.spring.service.impl;

import net.nexsource.demo.java.spring.dao.impl.UserDaoImpl;
import net.nexsource.demo.java.spring.model.User;
import net.nexsource.demo.java.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    @Transactional
    public void register(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<User> findAll() {
        return userDao.findAll();
    }
}
