package com.raif.javahack.javahack.service;

import com.raif.javahack.javahack.converter.BusinessConverter;
import com.raif.javahack.javahack.dao.BusinessRawMapper;
import com.raif.javahack.javahack.dto.BusinessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {
    private BusinessRawMapper businessDao;
    private BusinessConverter businessConverter;

    @Autowired
    public BusinessService(BusinessRawMapper businessDao, BusinessConverter businessConverter) {
        this.businessDao = businessDao;
        this.businessConverter = businessConverter;
    }

    public BusinessDTO getBusinessById(Long id){
        BusinessDTO dto = businessConverter.convert(businessDao.getBusinessById(id));
        return dto;
    }

    public List<BusinessDTO> getBusinessDTOs(Long okved){
        return businessDao.getBusinessByOkved(okved)
                .stream()
                .map(s -> businessConverter.convert(s))
                .collect(Collectors.toList());
    }

}
