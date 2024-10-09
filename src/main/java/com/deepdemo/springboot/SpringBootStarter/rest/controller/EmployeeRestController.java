package com.deepdemo.springboot.SpringBootStarter.rest.controller;


// because we are using spring data-rest
import com.deepdemo.springboot.SpringBootStarter.rest.dao.EmployeeDao;
import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import com.deepdemo.springboot.SpringBootStarter.rest.exception.StudentNotFoundExceptions;
import com.deepdemo.springboot.SpringBootStarter.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
@RestController
@RequestMapping("/api2")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee employee(@PathVariable int id) {
        Employee employee = employeeService.findEmployee(id);
        if (employee == null) {
            throw new StudentNotFoundExceptions("No employee found: " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findEmployee(id);
        if (employee == null) {
            throw new StudentNotFoundExceptions("No employee found: " + id);
        }
        employeeService.deleteEmployee(id);
        return "Deleted employee id " + id;
    }

*//*
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
    }*//*
}*/
