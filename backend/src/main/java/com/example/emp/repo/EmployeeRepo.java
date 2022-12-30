package com.example.emp.repo;

import com.example.emp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {}
