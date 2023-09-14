package com.branchmicroservice.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDetailsDTO {
    private String branchCode;

    private String branchName;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String addressLine4;

    private String branchPostcode;

    private String branchPhoneNumber;

    private String branchEmailAddress;

    private List<EmployeeDTO> employeeList;
}
