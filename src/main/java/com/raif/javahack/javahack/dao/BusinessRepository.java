package com.raif.javahack.javahack.dao;

import com.raif.javahack.javahack.dao.api.BusinessDao;
import com.raif.javahack.javahack.model.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessRepository implements BusinessDao {
    @Autowired
    private JdbcTemplate template;


    @Override
    public Business getBusinessById(Long id) {

        return null;
    }
}
