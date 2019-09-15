package com.raif.javahack.javahack.service;

import com.raif.javahack.javahack.converter.BusinessConverter;
import com.raif.javahack.javahack.dao.BusinessRawMapper;
import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.model.Business;
import com.raif.javahack.javahack.model.ConsAndProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class BusinessService {
    private BusinessRawMapper businessDao;
    private BusinessConverter businessConverter;

    @Autowired
    public BusinessService(BusinessRawMapper businessDao, BusinessConverter businessConverter) {
        this.businessDao = businessDao;
        this.businessConverter = businessConverter;
    }

    public BusinessDTO getBusinessById(Long id) {
        BusinessDTO dto = businessConverter.convert(businessDao.getBusinessById(id));


        return dto;
    }

    public List<BusinessDTO> getBusinessDTOs(Long okved) {
        List<BusinessDTO> businessDTOS = businessDao.getBusinessByOkved(okved)
                .stream()
                .map(s -> businessConverter.convert(s))
                .collect(toList());


        return businessDTOS;
    }

    public BusinessDTO getBusinessByInn(String inn) {

        BusinessDTO dto = businessConverter.convert(businessDao.getBusinessByInn(inn));

        setProdAndConsToDTO(dto);
        return dto;
    }

    private void setProdAndConsToDTO(BusinessDTO dto) {
        List<ConsAndProd> cons = businessDao.getConsumersById(dto.getId());
        List<ConsAndProd> prods = businessDao.getProducersById(dto.getId());

        List<Long> consIds = cons.stream().map(s -> s.getConsOrProdId()).collect(Collectors.toList());
        List<Long> prodIds = prods.stream().map(s -> s.getConsOrProdId()).collect(Collectors.toList());

        List<Business> consBusinesses = consIds
                                        .stream()
                                        .map(s -> businessDao.getBusinessById(s))
                                        .collect(Collectors.toList());
        List<Business> prodsBusinesses = prodIds
                                        .stream()
                                        .map(s -> businessDao.getBusinessById(s))
                                        .collect(Collectors.toList());


        dto.setRecomConsumers(consBusinesses);
        dto.setRecomProducers(prodsBusinesses);
    }
}
