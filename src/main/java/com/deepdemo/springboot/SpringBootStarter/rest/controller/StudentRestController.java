package com.deepdemo.springboot.SpringBootStarter.rest.controller;

import com.deepdemo.springboot.SpringBootStarter.rest.model.Student;
import com.deepdemo.springboot.SpringBootStarter.rest.exception.StudentErrorResponse;
import com.deepdemo.springboot.SpringBootStarter.rest.exception.StudentNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student(1, "Deep", "Singh", true));
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student(1, "Deep", "Singh", true));
        theStudents.add(new Student(2, "Deep", "Singh", true));
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundExceptions("Student id not found " + studentId);
        }
        return theStudents.get(studentId);
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
