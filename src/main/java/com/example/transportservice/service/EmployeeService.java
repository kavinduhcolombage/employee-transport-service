package com.example.transportservice.service;

import com.example.transportservice.model.Employee;

public interface EmployeeService {
    Employee registerEmployee(Employee employee);
    Employee getEmployeeById(Long id);
}
