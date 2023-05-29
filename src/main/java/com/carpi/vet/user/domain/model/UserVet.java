package com.carpi.vet.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVet {
    private Long id;
    private String email;
    private String password;
    private String name;
}
