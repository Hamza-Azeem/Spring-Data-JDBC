package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.models.Employee;
import com.example.springdatajdbc.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employee")
public class HomeController {
    private final EmployeeRepo employeeRepo;
    public HomeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @GetMapping("/count")
    public long countEmp(){
        return employeeRepo.count();
    }
    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable("id") long id){
        return employeeRepo.findById(id).get();
    }
    @GetMapping("")
    public Iterable<Employee> findEmployees(){
        return employeeRepo.findAll();
    }
    @PostMapping("")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
    @GetMapping("/contains/{letters}")
    public List<Employee> findEmpNamesLike(@PathVariable("letters") String letters){
        letters = new String("%"+letters+"%");
        return employeeRepo.findByNameLike(letters);
    }
    @GetMapping("/startWith/{name}/{id}")
    public List<Employee>findEmployeesLikeNameAndId(@PathVariable("name") String name, @PathVariable("id") long id){
        return employeeRepo.findByNameStartsWithAndIdGreaterThanEqual(name, id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable("id") long id){
        employeeRepo.deleteById(id);
    }

}
