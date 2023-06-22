package com.carpi.vet.center.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Center {

    private Integer id;
    private String name;
    private String address;
    private String phone;
}
