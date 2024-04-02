package com.inn.qms.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(value={DataNotFoundException.class})
    public ResponseEntity<Object> handleSiteNotFoundException(DataNotFoundException NotFoundException)
    {
        DataException exception=new DataException(
                NotFoundException.getMessage(),
                NotFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}