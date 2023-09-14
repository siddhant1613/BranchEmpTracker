package com.branchmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.branchmicroservice.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	Employee findByEmpId(String empId);
	List<Employee> findByBranchCode(String branchCode);

}
