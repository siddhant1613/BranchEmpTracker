package com.branchmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.branchmicroservice.dto.EmployeeDTO;
import com.branchmicroservice.response.ResponseHandler;
import com.branchmicroservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO){
		try {
			//return new ResponseEntity<> ( employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
			return ResponseHandler.generateResponse("Succesfully added Employee Details", HttpStatus.CREATED, employeeService.createEmployee(employeeDTO));
			}
			catch(Exception e) {
				
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
			}
	}
	
	
	@GetMapping("/employee")
	public ResponseEntity<Object> retreiveAllEmployee(){
		try {
			//return new ResponseEntity<> ( employeeService.getAllEmployeeDetails(), HttpStatus.OK);
			return ResponseHandler.generateResponse("Succesfully fetched employee Details", HttpStatus.OK, employeeService.getAllEmployeeDetails());
			}
			catch(Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
			}
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		try {
			//return new ResponseEntity<> ( employeeService.updateEmployee(employeeDTO), HttpStatus.OK);
			return ResponseHandler.generateResponse("Succesfully updated employee Details", HttpStatus.OK, employeeService.updateEmployee(employeeDTO));
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<Object> deleteMapping(@PathVariable("employeeId") String employeeId){
		try {
			employeeService.deleteEmployeeByEmployeeId(employeeId);
			//return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			return ResponseHandler.generateResponse("Succesfully deleted employee", HttpStatus.OK, null);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	

}
