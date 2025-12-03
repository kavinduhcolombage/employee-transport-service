package com.example.transportservice.dto.employee.request;

import lombok.Data;

@Data
public class EmployeeCreateRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
