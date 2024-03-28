package com.inn.qms.Exception1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(value={DataNotFoundException.class})
    public ResponseEntity<Object> handleSiteNotFoundException(DataNotFoundException siteNotFoundException)
    {
        DataException siteException=new DataException(
                siteNotFoundException.getMessage(),
                siteNotFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(siteException, HttpStatus.NOT_FOUND);
    }
}
