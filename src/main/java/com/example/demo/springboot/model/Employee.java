package com.example.demo.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name= "firstname")
    private String firstname;
    @Column(name= "lastname")
    private String lastname;
    @Column(name= "emailId")
    private String email;
    @Column(name= "salary")
    private Float salary;
}
