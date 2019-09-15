package com.raif.javahack.javahack.controller;

import com.raif.javahack.javahack.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class Controller {
    @Autowired
    Example example;

    @RequestMapping("/")
    public Set<String> greeting(@RequestParam(value="okved", required=false) String okved) {
        example.setProducerList(okved,new String[] {"Vera","Nadezda", "Lubov"});
        return example.getProducerList(okved);
    }
}
