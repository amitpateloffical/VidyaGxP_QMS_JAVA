package com.inn.qms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Setter
@Getter
public class ApiExceptionResponse {

    private  String timeStamp;
    private  Integer status;
    private  String error;
    private  String message;

    public ApiExceptionResponse() {
      this.timeStamp = Instant.now().toString();
    }



    public ApiExceptionResponse(Integer status, String error, String message) {
        this.timeStamp= Instant.now().toString();
        this.status=status;
        this.error=error;
        this.message=message;
    }

}
