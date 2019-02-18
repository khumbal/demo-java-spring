package com.khumbal.demo.java.spring.service.impl;

import com.khumbal.demo.java.spring.dao.CountryDao;
import com.khumbal.demo.java.spring.model.Country;
import com.khumbal.demo.java.spring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Country> findAll() {
        return countryDao.findAll();
    }
}
