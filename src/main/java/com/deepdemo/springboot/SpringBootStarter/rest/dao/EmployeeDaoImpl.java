package com.deepdemo.springboot.SpringBootStarter.rest.dao;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(@Qualifier("secondaryEntityManagerFactory") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findEmployeeByLastName(String lastname) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Student WHERE lastName='Doe'", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee updatEmployee(int id) {
        Employee student = entityManager.find(Employee.class, id);
        //change first name
        student.setFirstName("Deepankar");
        return entityManager.merge(student); // update row;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee student = entityManager.find(Employee.class, id);
        entityManager.remove(student);

    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE from Student").executeUpdate();
    }
}
