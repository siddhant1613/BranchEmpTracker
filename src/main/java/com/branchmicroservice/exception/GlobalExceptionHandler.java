package com.branchmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.branchmicroservice.exception.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler{
	/*
	 * @ExceptionHandler(IdNotFoundException.class) public
	 * ResponseEntity<ApiResponse>
	 * handlerResourceNotFoundException(IdNotFoundException ex){ String message =
	 * ex.getMessage(); ApiResponse response = ApiResponse .builder()
	 * .message(message) .status(HttpStatus.BAD_REQUEST) .build(); return new
	 * ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST); }
	 */

	@ExceptionHandler(EmployeeAlreadyExistException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(EmployeeAlreadyExistException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(EmployeeNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(BranchAlreadyExistException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(BranchAlreadyExistException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(BranchNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
        }
