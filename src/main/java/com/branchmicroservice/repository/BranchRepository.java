package com.branchmicroservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.branchmicroservice.entity.Branch;

@Repository
public interface BranchRepository extends MongoRepository<Branch, String> {
	
	Branch  findByBranchCode(String branchCode);

}
