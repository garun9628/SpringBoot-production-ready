package com.springboot.prod_ready_features.prod_ready_features;

import com.springboot.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.springboot.prod_ready_features.prod_ready_features.clients.EmployeeClient;
import com.springboot.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void createEmployeeTest() {
		EmployeeDTO employeeDTO = new EmployeeDTO(null, "arun", "arun@123", 2, "USER", LocalDate.of(2022, 12, 1), true);
		ApiResponse<EmployeeDTO> employee = employeeClient.createEmployee(employeeDTO);
		System.out.println(employee);
	}

}
