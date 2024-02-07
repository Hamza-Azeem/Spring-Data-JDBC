package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.models.Employee;
import com.example.springdatajdbc.repository.EmployeeRepo;
import com.example.springdatajdbc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employee")
public class HomeController {
    private final EmployeeService employeeService;
    public HomeController(EmployeeRepo employeeRepo, EmployeeService employeeService){
        this.employeeService = employeeService;

    }
    @GetMapping("/count")
    public long countEmp(){
        return employeeService.countEmployees();
    }
    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable("id") long id){
        return employeeService.findEmployeeById(id);
    }
    @GetMapping("")
    public Iterable<Employee> findEmployees(){
        return employeeService.findAllEmployees();
    }
    @PostMapping("")
    public int saveEmployee(@RequestBody Employee employee){
        return employeeService.insertNewEmployee(employee);
    }
    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @GetMapping("/contains/{letters}")
    public List<Employee> findEmpNamesLike(@PathVariable("letters") String letters){
        return employeeService.findEmployeesByNameContains(letters);
    }
    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }
    @PutMapping("/salary")
    public int updateSalaryOfEmployee(@RequestParam long id, @RequestParam String salary){
        return employeeService.updateEmployeeSalary(id, salary);
    }

}
