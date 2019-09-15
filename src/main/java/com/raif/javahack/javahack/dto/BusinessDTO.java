package com.raif.javahack.javahack.dto;

import com.raif.javahack.javahack.model.Business;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long inn;
    private Long okved;
    private String post;
    private String full_with_opf;
    private String short_with_opf;
    private String adress;

    private List<Business> recomProducers;
    private List<Business> recomConsumers;
}
