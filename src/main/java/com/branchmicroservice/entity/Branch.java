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
@Document(collection = "Branch_Details")
public class Branch {

	@Id
	private String id;
	

	private String branchCode;
	

	private String branchName;
	

	private String addressLine1;
	

	private String addressLine2;
	

	private String addressLine3;
	

	private String addressLine4;
	

	private String branchPostcode;
	

	private String branchPhoneNumber;
	

	private String branchEmailAddress;
	
	
	
	

}
