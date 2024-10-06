package com.deepdemo.springboot.SpringBootStarter.rest.dao;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Employee getStudent(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Student WHERE lastName='Doe'", Employee.class);
        List<Employee> students = query.getResultList();
        return students;
    }

    @Override
    @Transactional
    public Employee updatStudent(int id) {
        Employee student = entityManager.find(Employee.class, id);
        //change first name
        student.setFirstName("Deepankar");
        return entityManager.merge(student); // update row;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Employee student = entityManager.find(Employee.class, id);
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numRowsDeleted;
    }
}
