package com.car.car.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UtilAPI {
    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("Mensaje" + message, httpStatus);
    }
}
