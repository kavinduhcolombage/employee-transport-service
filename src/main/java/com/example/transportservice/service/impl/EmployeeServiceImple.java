package com.example.transportservice.service.impl;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;
import com.example.transportservice.exception.EmployeeException;
import com.example.transportservice.mapper.EmployeeMapper;
import com.example.transportservice.model.Employee;
import com.example.transportservice.repo.EmployeeRepository;
import com.example.transportservice.service.EmployeeService;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImple implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeCreateRequestDto requestDto) {
        Optional<Employee> employee = employeeRepository.findByEmail(requestDto.getEmail());
        if (employee.isPresent()) {
            throw new EmployeeException("Employee Already Registered");
        }
        Employee saved = employeeRepository.save(EmployeeMapper.toEntity(requestDto));
        return EmployeeMapper.toResponse(saved);
    }
}
