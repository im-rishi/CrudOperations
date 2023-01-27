package com.example.demo.springboot.service;

import com.example.demo.springboot.exception.ResourceNotFoundException;
import com.example.demo.springboot.model.Employee;
import com.example.demo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(@PathVariable long id){
       return  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"  + id));

    }

    public Employee updateEmployee(@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(employeeDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmail(employeeDetails.getEmail());

        return employeeRepository.save(updateEmployee);

    }

    public String deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new <String>ResourceNotFoundException("Not Found"));

        employeeRepository.delete(employee);
        return "successfully deleted";
    }


}
