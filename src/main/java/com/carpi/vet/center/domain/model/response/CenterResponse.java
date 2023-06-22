package com.carpi.vet.center.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterResponse {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String image;
}
