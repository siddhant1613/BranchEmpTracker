package com.branchmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branchmicroservice.dto.EmployeeDTO;
import com.branchmicroservice.entity.Employee;
import com.branchmicroservice.exception.EmployeeAlreadyExistException;
import com.branchmicroservice.exception.EmployeeNotFoundException;
import com.branchmicroservice.mapping.EmployeeEntityDtoMapping;
import com.branchmicroservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeEntityDtoMapping employeeEntityDtoMapping;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		if(employeeRepository.findByEmpId(employeeDTO.getEmpId())!=null) {
			throw new EmployeeAlreadyExistException("Employee Already Exist with given employee id");
		}
		return employeeEntityDtoMapping.convertEmployeeToEmployeeDTO(employeeRepository.save(employeeEntityDtoMapping.convertEmployeeDTOtoEmployee(employeeDTO)));
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		if(employeeRepository.findByEmpId(employeeDTO.getEmpId())==null) {
			throw new EmployeeNotFoundException("Employee not found with given Employee Id");
		}
		
		Employee employee = employeeRepository.findByEmpId(employeeDTO.getEmpId());
		employee.setName(employeeDTO.getName());
		employee.setMobileNo(employeeDTO.getMobileNo());
		employee.setBranchCode(employeeDTO.getBranchCode());
		employee.setAddress(employeeDTO.getAddress());
		return employeeEntityDtoMapping.convertEmployeeToEmployeeDTO(employeeRepository.save(employee));
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeDetails() {
		return employeeEntityDtoMapping.convertListEmployeeListToDTOList(employeeRepository.findAll());
	}

	@Override
	public void deleteEmployeeByEmployeeId(String employeeId) {
		if(employeeRepository.findByEmpId(employeeId)==null) {
			throw new EmployeeNotFoundException("Employee not found with given employee id");
		}
		Employee employee = employeeRepository.findByEmpId(employeeId);
		employeeRepository.deleteById(employee.getId());
		
	}

}
