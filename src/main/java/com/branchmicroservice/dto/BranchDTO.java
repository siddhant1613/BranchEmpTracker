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
public class BranchDTO {

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
