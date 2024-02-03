package com.example.springdatajdbc.repository;

import com.example.springdatajdbc.models.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee WHERE name LIKE :name")
    List<Employee> findByNameLike(@Param("name") String name);
    List<Employee> findByNameStartsWithAndIdGreaterThanEqual(String name, Long id);

}
