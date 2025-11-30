package com.example.transportservice.service.impl;

import com.example.transportservice.model.Employee;
import com.example.transportservice.repo.EmployeeRepository;
import com.example.transportservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImple implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = employeeRepository.findById(id).orElse(null);
        if (emp == null) {
            return null;
        }
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());

        return employeeRepository.save(emp);
    }
}
