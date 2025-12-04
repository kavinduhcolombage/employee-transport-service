package com.example.transportservice.service.impl;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.request.EmployeeUpdateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;
import com.example.transportservice.exception.EmployeeException;
import com.example.transportservice.exception.EmployeeNotFoundException;
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

    @Override
    public EmployeeResponseDto updateEmployee(Long id, EmployeeUpdateRequestDto requestDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        if (requestDto.getFirstName() != null && !requestDto.getFirstName().isEmpty()) {
            employee.setFirstName(requestDto.getFirstName());
        }
        if (requestDto.getLastName() != null && !requestDto.getLastName().isEmpty()) {
            employee.setLastName(requestDto.getLastName());
        }
        if (requestDto.getPhone() != null && !requestDto.getPhone().isEmpty()) {
            employee.setPhone(requestDto.getPhone());
        }
        if (requestDto.getPassword() != null && !requestDto.getPassword().isEmpty()) {
            employee.setPassword(requestDto.getPassword());
        }

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.toResponse(updatedEmployee);

    }
}
