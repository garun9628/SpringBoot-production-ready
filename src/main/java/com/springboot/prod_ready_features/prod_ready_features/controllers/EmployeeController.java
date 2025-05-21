package com.springboot.prod_ready_features.prod_ready_features.controllers;

import com.springboot.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.springboot.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.springboot.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/posts")
public class EmployeeController {

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping(path = "/employees")
    ApiResponse<EmployeeDTO> createEmployeeTest(@RequestBody EmployeeDTO employeeDTO) {
        return employeeClient.createEmployee(employeeDTO);
    }
}
