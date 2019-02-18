package com.khumbal.demo.java.spring.dao;

import com.khumbal.demo.java.spring.model.Country;

import java.util.List;

public interface CountryDao {

    public List<Country> findAll();

}
