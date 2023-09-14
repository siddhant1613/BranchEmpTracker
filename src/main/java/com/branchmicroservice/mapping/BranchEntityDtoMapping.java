package com.branchmicroservice.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.branchmicroservice.dto.BranchDTO;
import com.branchmicroservice.entity.Branch;

@Service
public class BranchEntityDtoMapping {
	
	public BranchDTO convertBranchToBranchDTO( Branch branch) {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setBranchCode(branch.getBranchCode());
		branchDTO.setBranchName(branch.getBranchName());
		branchDTO.setAddressLine1(branch.getAddressLine1());
		branchDTO.setAddressLine2(branch.getAddressLine2());
		branchDTO.setAddressLine3(branch.getAddressLine3());
		branchDTO.setAddressLine4(branch.getAddressLine4());
		branchDTO.setBranchPostcode(branch.getBranchPostcode());
		branchDTO.setBranchPhoneNumber(branch.getBranchPhoneNumber());
		branchDTO.setBranchEmailAddress(branch.getBranchEmailAddress());
		
		return branchDTO;				
	}
	
	public Branch converBranchDTOTobranch(BranchDTO branchDTO) {
		Branch branch = new Branch();
		branch.setBranchCode(branchDTO.getBranchCode());
		branch.setBranchName(branchDTO.getBranchName());
		branch.setAddressLine1(branchDTO.getAddressLine1());
		branch.setAddressLine2(branchDTO.getAddressLine2());
		branch.setAddressLine3(branchDTO.getAddressLine3());
		branch.setAddressLine4(branchDTO.getAddressLine4());
		branch.setBranchPostcode(branchDTO.getBranchPostcode());
		branch.setBranchPhoneNumber(branchDTO.getBranchPhoneNumber());
		branch.setBranchEmailAddress(branchDTO.getBranchEmailAddress());
		
		return branch;
		
	}
	
	public List<Branch> convertListBranchDtoListToBranchList(List<BranchDTO> branchDtoList)
	{
		List<Branch> branchList = new ArrayList<Branch>();
		for(int i=0;i<branchDtoList.size();i++)
		{
			Branch branch = new Branch();
			branch = converBranchDTOTobranch(branchDtoList.get(i));
			branchList.add(branch);
		}
		
		return branchList;
		
	}
	
	public List<BranchDTO> convertListBranchListToBranchDtoList(List<Branch> branchList)
	{
		List<BranchDTO> branchDtoList = new ArrayList<BranchDTO>();
		for(int i=0;i<branchList.size();i++)
		{
			BranchDTO branchDTO = new BranchDTO();
			branchDTO = convertBranchToBranchDTO(branchList.get(i));
			branchDtoList.add(branchDTO);
		}
		return branchDtoList;
	}

}
