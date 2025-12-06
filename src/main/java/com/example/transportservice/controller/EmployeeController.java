package com.example.transportservice.controller;

import com.example.transportservice.dto.employee.request.EmployeeCreateRequestDto;
import com.example.transportservice.dto.employee.request.EmployeeUpdateRequestDto;
import com.example.transportservice.dto.employee.response.EmployeeResponseDto;
import com.example.transportservice.payload.ApiResponse;
import com.example.transportservice.repo.EmployeeRepository;
import com.example.transportservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> registerEmployee(@RequestBody EmployeeCreateRequestDto requestDto) {

        EmployeeResponseDto responseDto = employeeService.createEmployee(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201,"Employee Created" , responseDto));

    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateRequestDto requestDto){
        EmployeeResponseDto responseDto = employeeService.updateEmployee(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200, "Employee Updated", responseDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200, "Employee Deleted", "Employee id "+id+" deleted"));
    }

}
