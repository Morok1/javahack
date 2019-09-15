package com.raif.javahack.javahack.dao.api;

import com.raif.javahack.javahack.dto.BusinessDTO;
import com.raif.javahack.javahack.model.Business;

import java.util.List;

public interface BusinessDao {
    Business getBusinessById(Long id);

    List<Business> getBusinessByOkved(Long okved);
    Business getBusinessByInn(String inn);
}
