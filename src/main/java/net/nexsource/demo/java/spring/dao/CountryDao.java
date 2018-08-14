package net.nexsource.demo.java.spring.dao;

import net.nexsource.demo.java.spring.model.Country;

import java.util.List;

public interface CountryDao {

    public List<Country> findAll();

}
