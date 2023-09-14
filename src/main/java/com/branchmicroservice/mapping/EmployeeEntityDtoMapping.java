package com.branchmicroservice.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.branchmicroservice.dto.EmployeeDTO;
import com.branchmicroservice.entity.Employee;

@Service
public class EmployeeEntityDtoMapping {
	
	public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(employee.getEmpId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setMobileNo(employee.getMobileNo());
		employeeDTO.setAddress(employee.getAddress());
		employeeDTO.setBranchCode(employee.getBranchCode());
		
		return employeeDTO;
	}
	
	
	public Employee convertEmployeeDTOtoEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();
		employee.setEmpId(employeeDTO.getEmpId());
		employee.setName(employeeDTO.getName());
		employee.setMobileNo(employeeDTO.getMobileNo());
		employee.setAddress(employeeDTO.getAddress());
		employee.setBranchCode(employeeDTO.getBranchCode());
		
		return employee;
		
	}
	
	public List<Employee> convertListEmployeeDTOListToEntityList(List<EmployeeDTO> employeeDTOList){
		
		List<Employee> employeeList = new ArrayList<Employee>();
		for(int i=0;i<employeeDTOList.size();i++)
		{
			Employee employee = new Employee();
			employee = convertEmployeeDTOtoEmployee(employeeDTOList.get(i));
			employeeList.add(employee);
		}
		
		return employeeList;
		
	}
	
	public List<EmployeeDTO> convertListEmployeeListToDTOList(List<Employee> employeeList){
		List<EmployeeDTO> employeeDTOList =  new ArrayList<EmployeeDTO>();
		for(int i=0;i<employeeList.size();i++)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO = convertEmployeeToEmployeeDTO(employeeList.get(i));
			employeeDTOList.add(employeeDTO);
		}
		
		return employeeDTOList;
	}

}
