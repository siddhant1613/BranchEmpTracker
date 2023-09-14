package com.branchmicroservice.controller;



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

import com.branchmicroservice.dto.BranchDTO;
import com.branchmicroservice.response.ResponseHandler;
import com.branchmicroservice.service.BranchService;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;
	
	
	
	@PostMapping("/branch")
	public ResponseEntity<Object>  addBranch(@RequestBody BranchDTO branchDTO)
	{
		try {
		//return new ResponseEntity<> ( branchService.createBranchdetails(branchDTO), HttpStatus.CREATED);
		return ResponseHandler.generateResponse("Succesfully added Branch Details", HttpStatus.CREATED, branchService.createBranchdetails(branchDTO));
		}
		catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	@GetMapping("/branch")
	public ResponseEntity<Object> retrieveAllBranchDetails(){
		try {
		//return new ResponseEntity<> (branchService.getAllbranchdetails(), HttpStatus.OK);
			return ResponseHandler.generateResponse("Succesfully fetched Branch Details", HttpStatus.OK, branchService.getAllbranchdetails());
		}
		catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@PutMapping("/branch")
	public ResponseEntity<Object> updateBranchDetails(@RequestBody BranchDTO branchDTO){
		try {
			//return new ResponseEntity<> (branchService.updateBranchdetails(branchDTO),HttpStatus.OK);
			return ResponseHandler.generateResponse("Succesfully updated Branch Details", HttpStatus.OK, branchService.updateBranchdetails(branchDTO));
		}
		catch(Exception e){
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@DeleteMapping("/branch/{branchCode}")
	public ResponseEntity<Object> deleteBranch(@PathVariable("branchCode") String branchCode){
		try {
			branchService.deleteBranchDetailByBranchCode(branchCode);
			//return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			return ResponseHandler.generateResponse("Succesfully Deleted Branch Details", HttpStatus.OK, null);
		}
		catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}
	
	

}
