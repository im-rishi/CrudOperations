package com.example.demo.springboot.repository;

import com.example.demo.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
