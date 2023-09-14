package com.branchmicroservice.service;

import java.util.List;

import com.branchmicroservice.dto.EmployeeDTO;

public interface EmployeeService {
 EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
 EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
 List<EmployeeDTO> getAllEmployeeDetails();
 void deleteEmployeeByEmployeeId(String employeeId);
}
