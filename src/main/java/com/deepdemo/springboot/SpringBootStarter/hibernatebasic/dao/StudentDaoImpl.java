package com.deepdemo.springboot.SpringBootStarter.hibernatebasic.dao;

import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findStudentByLastName(String lastname) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName='Doe'", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    @Transactional
    public Student updatStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        //change first name
        student.setFirstName("Deepankar");
        return entityManager.merge(student); // update row;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numRowsDeleted;
    }
}
