package com.example.transportservice.controller;

import com.example.transportservice.model.Employee;
import com.example.transportservice.payload.ApiResponse;
import com.example.transportservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable Long id){
        Employee emp = employeeService.getEmployeeById(id);
        ApiResponse<Employee> response;
        if(emp != null){
            response = new ApiResponse<>(200, "Employee found", emp);
            return ResponseEntity.ok(response);
        }else{
            response = new ApiResponse<>(404, "Employee not found", emp);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse<Employee>> registerEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.registerEmployee(employee);
        ApiResponse<Employee> response;
        if(emp != null){
            response = new ApiResponse<>(200,"Succesfully",emp);
            return ResponseEntity.ok(response);
        }else {
            response = new ApiResponse<>(500, "Failed", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }




}
