package com.example.finalassessmentweb.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> createResponse(String message, HttpStatus status, Object object) {

        Map<String,Object> response = new HashMap<>();
        response.put("payload",object);
        response.put("message",message);
        response.put("status",status);

        return new ResponseEntity<>(response,status);
    }


}
