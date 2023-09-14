package com.branchmicroservice.exception;

public class BranchAlreadyExistException extends RuntimeException{

	public BranchAlreadyExistException() {
		super();
	}

	public BranchAlreadyExistException(String message) {
		super(message);
	}

}
