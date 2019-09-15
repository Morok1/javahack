package com.raif.javahack.javahack.controller;

import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.model.Business;
import com.raif.javahack.javahack.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessController implements BusinessApi{
    @Autowired
    private BusinessService businessService;

    @GetMapping("/business/{id}")
    public BusinessDTO getBusinessById(@PathVariable("id") Long id){
        return  businessService.getBusinessById(id);
    }

    @GetMapping("/businesses_okved/{okved}")
    public List<BusinessDTO> getBusinesses(@PathVariable("okved") Long okved){
        return businessService.getBusinessDTOs(okved);
    }

    @Override
    @GetMapping("/business_inn/{inn}")
    public BusinessDTO getBusinessByInn(@PathVariable("inn") String inn) {

        return businessService.getBusinessByInn( inn);
    }




}
