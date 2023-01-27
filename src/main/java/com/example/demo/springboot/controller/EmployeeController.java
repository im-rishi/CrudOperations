package com.example.demo.springboot.controller;
import com.example.demo.springboot.model.Employee;
import com.example.demo.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employees1")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@RequestBody Employee employeeDetails) {
        return service.updateEmployee(employeeDetails);
    }


    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable long id) {
        return service.deleteEmployee(id);
    }
}




