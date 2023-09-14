package com.branchmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private String empId;

	
	private String name;

	
	private String address;

	
	private String mobileNo;


	private String branchCode;

}