package com.inn.qms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
   @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object>handleIllegalArgumentException(IllegalArgumentException exception){
       ApiExceptionResponse response = new ApiExceptionResponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),exception.getMessage());
       return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleAnyException(Exception exception){
       ApiExceptionResponse response = new ApiExceptionResponse(
               HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name(),exception.getMessage());
       return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

   }

}