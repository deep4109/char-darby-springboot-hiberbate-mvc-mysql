package com.deepdemo.springboot.SpringBootStarter.mvcthymeleaf.controller;

import com.deepdemo.springboot.SpringBootStarter.rest.entity.Employee;
import com.deepdemo.springboot.SpringBootStarter.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeMVCController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeMVCController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //list
    @GetMapping("/list")
    public String listEmployees(Model model) {
        //get from db
        List<Employee> theEmployees = employeeService.findAll();

        //add to spring model
        model.addAttribute("employees", theEmployees);

        return "list-employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        Employee dbEmployee = employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Employee employee = new Employee();
        //add to spring model
        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") Integer employeeId, Model model) {

        Employee dbEmployee = employeeService.findEmployee(employeeId);

        model.addAttribute("employee", dbEmployee);

        //send to form
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Integer employeeId) {

        employeeService.deleteEmployee(employeeId);

        return "redirect:/employees/list";
    }

}
