package com.deepdemo.springboot.SpringBootStarter.mvcthymeleaf.controller;

import com.deepdemo.springboot.SpringBootStarter.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MvcController {


    @Value("${countries}")
    List<String> countries;

    @Value("${countries}")
    List<String> languages;

    @Value("${systems}")
    List<String> systems;

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", LocalDateTime.now());
        return "helloworld";
    }

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @PostMapping("/processFormVersionTwo")
    public String processFormv2(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo!" + theName;

        model.addAttribute("message",result);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormv3(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = "Yo!" + theName;

        model.addAttribute("message",result);
        return "helloworld";
    }

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        Student student = new Student();


        model.addAttribute("student",student);

        //add countries
        model.addAttribute("countries",countries);

        //add languages
        model.addAttribute("languages",languages);

        //add systems
        model.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student, Model model) {



        //model.addAttribute("message",result);
        return "student-confirmation";
    }


}
