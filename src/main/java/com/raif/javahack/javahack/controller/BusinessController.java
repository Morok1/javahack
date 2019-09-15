package com.raif.javahack.javahack.controller;

import com.raif.javahack.javahack.dao.api.ConsumerOkvedDAO;
import com.raif.javahack.javahack.dao.api.ProducerOkvedDAO;
import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.intdadata.DaDataController;
import com.raif.javahack.javahack.intdadata.model.UserDto;
import com.raif.javahack.javahack.service.BusinessService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@Log
public class BusinessController implements BusinessApi {
    @Autowired
    private BusinessService businessService;

    @Autowired
    private DaDataController daDataController;

    @Autowired
    private ConsumerOkvedDAO consumerOkvedDAO;

    @Autowired
    private ProducerOkvedDAO producerOkvedDAO;

    @GetMapping("/business/{id}")
    public BusinessDTO getBusinessById(@PathVariable("id") Long id) {
        return businessService.getBusinessById(id);
    }

    @GetMapping("/businesses_okved/{okved}")
    public List<BusinessDTO> getBusinesses(@PathVariable("okved") Long okved) {
        return businessService.getBusinessDTOs(okved);
    }

    @Override
    @GetMapping("/business_inn/{inn}")
    public BusinessDTO getBusinessByInn(@PathVariable("inn") String inn) {
        int okved = getOkvedByInn(inn);

        return businessService.getBusinessByInn(inn);
    }


    @GetMapping("/recomendations/{id}")
    public List<BusinessDTO> getRedisData(Long id){
        BusinessDTO dto = businessService.getBusinessById(id);
        Long okved = dto.getOkved();

        Set<Long> consumersOkveds  = consumerOkvedDAO.getProducerList(String.valueOf(okved));
        Set<Long> producersOkveds  = producerOkvedDAO.getProducerList(String.valueOf(okved));

        List<BusinessDTO> businesses = businessService.getBusinessDTOs(okved);

        return businesses;

    }


    private int getOkvedByInn(String inn) {
        UserDto userDto = null;
        int okved = 0;
        try {
            userDto = daDataController.getUserDataByInn(Long.valueOf(inn));
        } catch (IOException e) {
            log.info("Some problems with integration dadata !");
        }

        if (userDto != null) {
            okved = userDto.getOkved();
        }
        return okved;
    }
}
