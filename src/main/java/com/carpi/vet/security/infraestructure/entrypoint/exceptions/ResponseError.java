package com.carpi.vet.security.infraestructure.entrypoint.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseError {
    String message;
    int errorCode;
}
