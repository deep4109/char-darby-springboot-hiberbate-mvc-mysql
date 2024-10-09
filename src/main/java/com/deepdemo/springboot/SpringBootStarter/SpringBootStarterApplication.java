package com.deepdemo.springboot.SpringBootStarter;

import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.dao.StudentDao;
import com.deepdemo.springboot.SpringBootStarter.hibernatebasic.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.deepdemo.springboot.SpringBootStarter",
        "com.deepdemo.springboot.util"
}
)
@EnableAutoConfiguration
public class SpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            System.out.println("Hello World");
           // createStudent(studentDao);
           // getStudent(studentDao);
           // updateStudent(studentDao);
            //deleteStudent(studentDao);
            //deleteAll(studentDao);
        };
    }

    private void deleteAll(StudentDao studentDao) {

        //delete al  the student
        System.out.println("deleting all the student....");
        studentDao.deleteAll();
    }

    private void deleteStudent(StudentDao studentDao) {

        //delete the student
        System.out.println("delete the student....");
        studentDao.deleteStudent(2);
    }

    private void updateStudent(StudentDao studentDao) {

        //update the student
        System.out.println("updating the student....");
        Student student = studentDao.updatStudent(1);

        //display
        System.out.println("updated student student , Gstudent: " + student);


    }

    private void getStudent(StudentDao studentDao) {

        //save the student
        System.out.println("Saving the student....");
        Student student = studentDao.getStudent(1);

        //display id
        System.out.println("Retrieve student , Gstudent: " + student);

        //find by last name
        List<Student> students = studentDao.findStudentByLastName("Doe");
        System.out.println("Retrieve studentd by last name : " + students);
    }

    private void createStudent(StudentDao studentDao) {
        //create student
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Pauk", "Doe", "pauk@gmail.com");

        //save the student
        System.out.println("Saving the student....");
        studentDao.save(tempStudent);

        //display id
        System.out.println("Saved student , Generated id: " + tempStudent.getId());
    }

}
