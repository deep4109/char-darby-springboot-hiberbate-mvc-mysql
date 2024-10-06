package com.deepdemo.springboot.SpringBootStarter.rest.exception;

public class StudentNotFoundExceptions extends RuntimeException {

    public StudentNotFoundExceptions(String message) {
        super(message);
    }
}
