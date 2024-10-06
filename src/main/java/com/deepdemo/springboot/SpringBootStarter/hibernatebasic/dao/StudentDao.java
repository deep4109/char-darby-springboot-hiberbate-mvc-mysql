package com.deepdemo.springboot.SpringBootStarter.hibernatebasic.dao;

import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student getStudent(int id);

    List<Student> findStudentByLastName(String lastname);

    Student updatStudent(int id);

    void deleteStudent(int id);

    int deleteAll();

}
