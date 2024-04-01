package com.example.finalassessmentweb.beans;

import com.example.finalassessmentweb.exceptions.EntityIsAlreadyExistException;
import com.example.finalassessmentweb.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExtensionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFound(EntityNotFoundException customerNotFoundException) {

        Map<String,Object> response = new HashMap<>();
        response.put("errorMessage", customerNotFoundException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityIsAlreadyExistException.class})
    public ResponseEntity<Object> handleCustomerIsAlreadyExist(EntityIsAlreadyExistException customerIsAlreadyExistException) {

        Map<String,Object> response = new HashMap<>();
        response.put("errorMessage", customerIsAlreadyExistException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
