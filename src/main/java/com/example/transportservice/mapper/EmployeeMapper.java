package com.example.transportservice.mapper;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;
import com.example.transportservice.model.Employee;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeCreateRequestDto requestDto) {
        return Employee.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
    }

    public static EmployeeResponseDto toResponse(Employee employee) {
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .build();
    }
}
