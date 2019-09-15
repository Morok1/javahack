package com.raif.javahack.javahack.converter;

import com.raif.javahack.javahack.converter.api.Converter;
import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.model.Business;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BusinessConverter implements Converter<Business, BusinessDTO> {
    private ModelMapper mapper = new ModelMapper();
    @Override
    public BusinessDTO convert(Business business) {
        BusinessDTO dto = new BusinessDTO();
        dto.setId(business.getId());
        dto.setFirstName(business.getFirstName());
        dto.setLastName(business.getLastName());
        dto.setInn(business.getInn());
        dto.setFull_with_opf(business.getFull_with_opf());
        dto.setShort_with_opf(business.getShort_with_opf());
        dto.setPost(business.getPost());
        dto.setOkved(business.getOkved());
        return dto;
    }
}
