package net.nexsource.demo.java.spring.service.impl;

import net.nexsource.demo.java.spring.dao.CountryDao;
import net.nexsource.demo.java.spring.dao.impl.UserDaoImpl;
import net.nexsource.demo.java.spring.model.Country;
import net.nexsource.demo.java.spring.service.CountryService;
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
