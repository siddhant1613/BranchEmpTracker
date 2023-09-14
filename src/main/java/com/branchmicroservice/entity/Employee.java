package com.branchmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Employee_Details")
public class Employee {

	@Id
	private String id;


	private String empId;


	private String name;


	private String address;


	private String mobileNo;


	private String branchCode;

}
