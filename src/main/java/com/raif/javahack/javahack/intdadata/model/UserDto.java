package com.raif.javahack.javahack.intdadata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int okved;
    private Long inn;
    private int category;
}
