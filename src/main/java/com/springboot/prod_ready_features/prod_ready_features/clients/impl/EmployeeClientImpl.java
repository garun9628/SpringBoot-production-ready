package com.springboot.prod_ready_features.prod_ready_features.clients.impl;

import com.springboot.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.springboot.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.springboot.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import com.springboot.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        log.trace("Trying to retrieve all employees");
        try{
           List<EmployeeDTO> employeeDTOList = restClient.get()
                   .uri("employees")
                   .retrieve()
                   .onStatus(HttpStatusCode::is4xxClientError,
                           (req, res) -> {
                       log.error(new String(res.getBody().readAllBytes()));
                       throw new ResourceNotFoundException("Could not get the employees");
                   })
                   .body(new ParameterizedTypeReference<>() {
                    });
            log.info("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved employees list in getAllEmployees : {}, {}, {}", employeeDTOList, "Hello", 5);
            return employeeDTOList;
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees ", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public ApiResponse<EmployeeDTO> createEmployee(EmployeeDTO employeeDTO) {
        try {
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,
                            (req, res) -> {
                        throw new ResourceNotFoundException("Could not create the employee ");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            System.out.println("%%%%%%%%%%" + employeeResponse);
            return employeeResponse.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
