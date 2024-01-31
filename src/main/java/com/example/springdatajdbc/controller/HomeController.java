package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class HomeController {
    private final EmployeeRepo employeeRepo;
    public HomeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @GetMapping("/count")
    public long getCount(){
        return employeeRepo.count();
    }
}
