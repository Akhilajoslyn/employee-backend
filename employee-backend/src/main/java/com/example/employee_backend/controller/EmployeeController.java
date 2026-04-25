package com.example.employee_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee_backend.entity.Employee;
import com.example.employee_backend.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee add(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteEmployee(id);
    }
    
    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee emp) {
        emp.setId(id);
        return service.saveEmployee(emp);
    }
}