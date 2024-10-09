package com.deepdemo.springboot.SpringBootStarter.rest.service;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import com.deepdemo.springboot.SpringBootStarter.rest.springdatajpa.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /* private EmployeeDao employeeDao;*/
    private EmployeeJPARepository employeeRepository;

    /*@Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }*/

    @Autowired
    public EmployeeServiceImpl(EmployeeJPARepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        //return employeeDao.findAll();
        return employeeRepository.findAll();
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public Employee save(Employee theStudent) {
        //return employeeDao.save(theStudent);
        return employeeRepository.save(theStudent);
    }

    @Override
    public Employee findEmployee(int id) {
        //return employeeDao.findEmployee(id);
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            return result.get();
        }
        return theEmployee;
    }


    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
       // return employeeDao.findEmployeeByLastName(lastname);
        return new ArrayList<>();
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public Employee updatEmployee(int id) {
        Employee student = null;
        //change first name
        return student; // update row;
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        //employeeDao.deleteEmployee(id);
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public int deleteAll() {
        employeeRepository.deleteAll();
        return 1;
        //return employeeDao.deleteAll();
    }
}
