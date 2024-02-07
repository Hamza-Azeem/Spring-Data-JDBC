package com.example.springdatajdbc.service;

import com.example.springdatajdbc.models.Employee;
import com.example.springdatajdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public long countEmployees(){
        return employeeRepo.count();
    }
    public Iterable<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee findEmployeeById(long id){
        return employeeRepo.findById(id).get();
    }
    public int insertNewEmployee(Employee employee){
        return employeeRepo.insertEmployee(employee.getId(), employee.getName(), employee.getSalary());
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployeeById(long id){
        employeeRepo.deleteById(id);
    }
    public List<Employee> findEmployeesByNameContains(String name){
        name = new String("%" + name + "%");
        return employeeRepo.findByNameLike(name);
    }

    public int updateEmployeeSalary(long id, String salary) {
        return employeeRepo.updateSalary(id, salary);
    }
}
