package com.deepdemo.springboot.SpringBootStarter.rest.springdatajpa;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee,Integer> {
}
