package com.carpi.vet.center.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {
    private Long idEmployee;
    private CenterResponse centerResponse;
    private List<String> roles;
}
