package com.deepdemo.springboot.SpringBootStarter.rest.dao;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee save(Employee theStudent);

    Employee findEmployee(int id);

    List<Employee> findEmployeeByLastName(String lastname);

    List<Employee> findAll();

    Employee updatEmployee(int id);

    void deleteEmployee(int id);

    int deleteAll();

}
