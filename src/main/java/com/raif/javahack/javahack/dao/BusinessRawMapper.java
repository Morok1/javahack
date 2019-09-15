package com.raif.javahack.javahack.dao;

import com.raif.javahack.javahack.dao.api.BusinessDao;
import com.raif.javahack.javahack.model.Business;
import com.raif.javahack.javahack.model.ConsAndProd;
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

    public List<ConsAndProd> getProducersById(Long id) {
        String query = "SELECT * FROM Producers where business_id = ";
        List<ConsAndProd> businesses = performQueryConsProd(id, query);
        return businesses;
    }

    public List<ConsAndProd> getConsumersById(Long id) {
        String query = "SELECT * FROM Consumers where business_id = ";
        List<ConsAndProd> consAndProds= performQueryConsProd(id, query);
        return consAndProds;
    }

    public Business getBusinessByInn(String inn) {
        String query = "SELECT * FROM BUSINESS where  INN= ";
        List<Business> businesses = performQuery(Long.valueOf(inn), query);
        Business business = businesses.stream().filter(s -> s.getInn().equals(Long.valueOf(inn)) )
                .findFirst().orElse(new Business());
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
        business.setInn(rs.getLong(4));
        business.setOkved(rs.getLong(5));
        business.setPost(rs.getString(6));
        business.setFull_with_opf(rs.getString(7));
        business.setShort_with_opf(rs.getString(8));
        business.setAdress(rs.getString(8));

        return business;
    }

    private List<ConsAndProd> performQueryConsProd(Long id, String query) {
        return jdbcTemplate.query(
                query + id, (rs, i) -> {
                    ConsAndProd consAndProd= getBusinessForProdAndCons(rs);
                    return consAndProd;
                });
    }

    private ConsAndProd getBusinessForProdAndCons(ResultSet rs) throws SQLException {
        ConsAndProd consAndProd = new ConsAndProd();

        consAndProd.setBusinessId(rs.getLong(2));
        consAndProd.setConsOrProdId(rs.getLong(3));

        return consAndProd;
    }


}
