package com.example.finalassessmentweb.exceptions;

public class EntityIsAlreadyExistException extends RuntimeException {

    public EntityIsAlreadyExistException(String message) {
        super(message);
    }
}
