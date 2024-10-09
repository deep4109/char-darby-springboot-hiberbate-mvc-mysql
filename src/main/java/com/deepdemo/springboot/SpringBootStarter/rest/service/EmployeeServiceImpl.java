package com.deepdemo.springboot.SpringBootStarter.rest.service;

import com.deepdemo.springboot.SpringBootStarter.rest.dao.EmployeeDao;
import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public Employee save(Employee theStudent) {
        return employeeDao.save(theStudent);
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeDao.findEmployee(id);
    }


    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
        return employeeDao.findEmployeeByLastName(lastname);
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public Employee updatEmployee(int id) {
        Employee student = employeeDao.updatEmployee(id);
        //change first name
        return student; // update row;
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    @Transactional("secondaryTransactionManager")
    public int deleteAll() {
        return employeeDao.deleteAll();
    }
}
