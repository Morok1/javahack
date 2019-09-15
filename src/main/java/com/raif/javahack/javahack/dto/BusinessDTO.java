package com.raif.javahack.javahack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long inn;
}
