package com.deepdemo.springboot.SpringBootStarter.hibernatebasic.controller;

import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.dao.StudentDao;
import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.entity.Student;
import com.deepdemo.springboot.SpringBootStarter.rest.exception.StudentNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentDao studentDao;

    @Autowired
    public StudentRestController(StudentDao employeeDao) {
        this.studentDao = employeeDao;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentDao.findStudentByLastName("Doe");
    }

/*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundExceptions exceptions) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exceptions.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //catch all exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }*/
}
