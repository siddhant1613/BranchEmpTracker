package com.branchmicroservice.mapping;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.branchmicroservice.dto.BranchDetailsDTO;
import com.branchmicroservice.repository.EmployeeRepository;
import com.branchmicroservice.dto.BranchDTO;
@Service
public class BranchDTOAndBranchDetailsDTOMapping {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeEntityDtoMapping employeeEntityDtoMapping;

    public BranchDetailsDTO convertBranchDTOToBranchDetails(BranchDTO branchDTO) {
        BranchDetailsDTO branchDetailsDTO = new BranchDetailsDTO();
        branchDetailsDTO.setBranchCode(branchDTO.getBranchCode());
        branchDetailsDTO.setBranchName(branchDTO.getBranchName());
        branchDetailsDTO.setAddressLine1(branchDTO.getAddressLine1());
        branchDetailsDTO.setAddressLine2(branchDTO.getAddressLine2());
        branchDetailsDTO.setAddressLine3(branchDTO.getAddressLine3());
        branchDetailsDTO.setAddressLine4(branchDTO.getAddressLine4());
        branchDetailsDTO.setBranchPostcode(branchDTO.getBranchPostcode());
        branchDetailsDTO.setBranchPhoneNumber(branchDTO.getBranchPhoneNumber());
        branchDetailsDTO.setBranchEmailAddress(branchDTO.getBranchEmailAddress());
        branchDetailsDTO.setEmployeeList(employeeEntityDtoMapping.convertListEmployeeListToDTOList(employeeRepository.findByBranchCode(branchDTO.getBranchCode())));

        return branchDetailsDTO;

    }

    public List<BranchDetailsDTO> convertBranchDTOListToBranchDetailsList(List<BranchDTO> branchDTOList){
        List<BranchDetailsDTO> branchDetailsDTOList = new ArrayList<BranchDetailsDTO>();
        for(int i=0;i<branchDTOList.size();i++)
        {
            BranchDetailsDTO branchDetailsDTO = new BranchDetailsDTO();
            branchDetailsDTO = convertBranchDTOToBranchDetails(branchDTOList.get(i));
            branchDetailsDTOList.add(branchDetailsDTO);
        }
        return branchDetailsDTOList;
    }
}
