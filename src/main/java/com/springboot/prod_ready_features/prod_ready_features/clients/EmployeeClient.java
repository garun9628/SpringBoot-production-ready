package com.springboot.prod_ready_features.prod_ready_features.clients;

import com.springboot.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.springboot.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    ApiResponse<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO);
}
