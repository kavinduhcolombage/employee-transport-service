package com.example.transportservice.dto.employee.request;

import lombok.Data;

@Data
public class EmployeeUpdateRequestDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
}
