package com.carpi.vet.security.infraestructure.entrypoint.exceptions;

import com.carpi.vet.utils.ErrorConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler
    public ResponseEntity<ResponseError> handleException(SQLException e, HttpServletRequest request) {
        ResponseError responseError = new ResponseError(e.getMessage(),e.getErrorCode());
        if(e.getErrorCode() == ErrorConstants.SqlErrorCode.DUPLICATE_FIELD){

            responseError.setMessage(ErrorConstants.SqlError.DUPLICATE_FIELD);
        }
        return ResponseEntity.status(500).body(responseError);
    }
}
