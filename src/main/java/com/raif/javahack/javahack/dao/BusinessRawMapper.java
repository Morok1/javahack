package com.raif.javahack.javahack.dao;

import com.raif.javahack.javahack.dao.api.BusinessDao;
import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.model.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BusinessRawMapper implements BusinessDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Business getBusinessById(Long id) {
        String query = "SELECT * FROM BUSINESS where  id = ";
        List<Business> businesses = performQuery(id, query);
        Business business = businesses.stream().filter(s -> s.getId() == id).findFirst().orElse(new Business());
        return business;
    }

    @Override
    public List<Business> getBusinessByOkved(Long okved) {
        String query = "SELECT * FROM BUSINESS where  okved= ";
        List<Business> businesses = performQuery(okved, query);
        return businesses;
    }

    private List<Business> performQuery(Long id, String query) {
        return jdbcTemplate.query(
                query + id, (rs, i) -> {
                    Business business = getBusiness(rs);
                    return business;
                });
    }

    private Business getBusiness(ResultSet rs) throws SQLException {
        Business business = new Business();
        business.setId( rs.getLong(1));
        business.setFirstName(rs.getString(2));
        business.setLastName(rs.getString(3));
        business.setInn( rs.getLong(4));
        return business;
    }


}
