//package com.raif.javahack.javahack.dao.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan("com.raif.javahack.javahack.dao")
//public class SpringJdbcConfig {
//    @Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:testdb");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        return dataSource;
//    }
//}
