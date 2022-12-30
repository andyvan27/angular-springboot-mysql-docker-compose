package com.example.emp.service;

import com.example.emp.exception.EmployeeNotFoundException;
import com.example.emp.model.Employee;
import com.example.emp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo empRepo;
    @Autowired
    public EmployeeService(EmployeeRepo empRepo) {
        this.empRepo = empRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return empRepo.save(employee);
    }

    public Iterable<Employee> findAllEmployees(){
        return empRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    public Employee findEmployee(Long id) {
        return empRepo.findById(id).orElseThrow(
                ()->new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }
}
