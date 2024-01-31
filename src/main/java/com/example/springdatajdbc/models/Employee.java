package com.example.springdatajdbc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String salary;
    public Employee(){};
    public Employee(Long id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getSalary() {
        return salary;
    }

    public void setSalary(String  salary) {
        this.salary = salary;
    }
}
