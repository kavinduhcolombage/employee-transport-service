package com.example.transportservice.service;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.request.EmployeeUpdateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeCreateRequestDto requestDto);
    EmployeeResponseDto updateEmployee(Long id, EmployeeUpdateRequestDto requestDto);
}
