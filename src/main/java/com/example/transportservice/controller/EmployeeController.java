package com.example.transportservice.controller;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;
import com.example.transportservice.payload.ApiResponse;
import com.example.transportservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> registerEmployee(@RequestBody EmployeeCreateRequestDto requestDto) {

        EmployeeResponseDto responseDto = employeeService.createEmployee(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201,"Employee Created" , responseDto));

    }

}
