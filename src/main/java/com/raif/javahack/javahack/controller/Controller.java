package com.raif.javahack.javahack.controller;

import com.raif.javahack.javahack.dao.api.ConsumerOkvedDAO;
import com.raif.javahack.javahack.dao.api.ProducerOkvedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private ConsumerOkvedDAO consumerOkvedDAO;

    @Autowired
    private ProducerOkvedDAO producerOkvedDAO;

    @RequestMapping("/")
    public Set<String> greeting(@RequestParam(value = "okved", required = false) String okved) {
        consumerOkvedDAO.setProducerList(okved, new String[]{"A", "B", "C"});
        producerOkvedDAO.setProducerList(okved, new String[]{"X", "Y", "Z"});
        System.out.println(consumerOkvedDAO.getProducerList(okved));
        System.out.println(producerOkvedDAO.getProducerList(okved));
        return producerOkvedDAO.getProducerList(okved);
    }
}
