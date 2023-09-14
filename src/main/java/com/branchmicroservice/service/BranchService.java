package com.branchmicroservice.service;

import java.util.List;

import com.branchmicroservice.dto.BranchDTO;
import com.branchmicroservice.dto.BranchDetailsDTO;

public interface BranchService {
	BranchDTO createBranchdetails(BranchDTO branchDTO);
	BranchDTO updateBranchdetails(BranchDTO branchDTO);
	List<BranchDetailsDTO> getAllbranchdetails();
	void deleteBranchDetailByBranchCode(String branchCode);
	

}
