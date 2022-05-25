package com.latihanDaerah.latihanDaerah.Exception;

import com.latihanDaerah.latihanDaerah.dto.response.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    private Response response;
    
    @ExceptionHandler(value = NullException.class)
    public ResponseEntity<?> nullAttribute(NullException nullException){
        response = new Response(HttpStatus.NOT_FOUND.value(), nullException.getMessage(), null);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> sameValue(BadRequestException e){
        response = new Response(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
