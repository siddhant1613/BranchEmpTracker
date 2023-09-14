package com.branchmicroservice.service;

import java.util.List;

import com.branchmicroservice.dto.BranchDetailsDTO;
import com.branchmicroservice.mapping.BranchDTOAndBranchDetailsDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branchmicroservice.dto.BranchDTO;
import com.branchmicroservice.entity.Branch;
import com.branchmicroservice.exception.BranchAlreadyExistException;
import com.branchmicroservice.exception.BranchNotFoundException;
import com.branchmicroservice.mapping.BranchEntityDtoMapping;
import com.branchmicroservice.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	BranchEntityDtoMapping branchEntityDtoMapping;

	@Autowired
	BranchDTOAndBranchDetailsDTOMapping branchDTOAndBranchDetailsDTOMapping;

	@Override
	public BranchDTO createBranchdetails(BranchDTO branchDTO) {
		if(branchRepository.findByBranchCode(branchDTO.getBranchCode())!=null) {
			throw new BranchAlreadyExistException("Branch Already exist");
		}
		return branchEntityDtoMapping.convertBranchToBranchDTO(branchRepository.save(branchEntityDtoMapping.converBranchDTOTobranch(branchDTO)));
	}

	@Override
	public BranchDTO updateBranchdetails(BranchDTO branchDTO) {
		if(branchRepository.findByBranchCode(branchDTO.getBranchCode())==null) {
			throw new BranchNotFoundException("Branch not found with given Brnach Code");
		}
		Branch branch = branchRepository.findByBranchCode(branchDTO.getBranchCode());
		branch.setBranchName(branchDTO.getBranchName());
		branch.setAddressLine1(branchDTO.getAddressLine1());
		branch.setAddressLine2(branchDTO.getAddressLine2());
		branch.setAddressLine3(branchDTO.getAddressLine3());
		branch.setAddressLine4(branchDTO.getAddressLine4());
		branch.setBranchPostcode(branchDTO.getBranchPostcode());
		branch.setBranchPhoneNumber(branchDTO.getBranchPhoneNumber());
		branch.setBranchEmailAddress(branchDTO.getBranchEmailAddress());
		
		return branchEntityDtoMapping.convertBranchToBranchDTO(branchRepository.save(branch));
		
		
	}

	@Override
	public List<BranchDetailsDTO> getAllbranchdetails() {
		List<BranchDTO> branchDTOList =  branchEntityDtoMapping.convertListBranchListToBranchDtoList(branchRepository.findAll());
		return branchDTOAndBranchDetailsDTOMapping.convertBranchDTOListToBranchDetailsList(branchDTOList);
	}

	@Override
	public void deleteBranchDetailByBranchCode(String branchCode) {
		if(branchRepository.findByBranchCode(branchCode)==null) {
			throw new BranchNotFoundException("Branch not found with given Brnach Code");
		}
		Branch branch = branchRepository.findByBranchCode(branchCode);
		branchRepository.deleteById(branch.getId());
		
	}

}
