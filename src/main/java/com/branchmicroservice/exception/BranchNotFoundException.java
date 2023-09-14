package com.branchmicroservice.exception;

public class BranchNotFoundException extends RuntimeException {

	public BranchNotFoundException() {
		super();
	}

	public BranchNotFoundException(String message) {
		super(message);
	}
	

}
