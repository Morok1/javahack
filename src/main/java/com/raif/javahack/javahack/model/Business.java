package com.raif.javahack.javahack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {
    private Long id;
    private String firstName;
    private String lastName;
    private Long inn;
}
