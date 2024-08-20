package com.multi.db.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Lejil
 *
 */

@RestControllerAdvice
public class EmployeeControllerAdvice {

	// Handle other exceptions globally
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred: " + ex.getMessage());
	}

	@ExceptionHandler(EmployeeServiceException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(EmployeeServiceException ex) {
		return createErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	private ResponseEntity<ErrorResponse> createErrorResponse(int errorCode, String message) {
		ErrorResponse errorResponse = new ErrorResponse(errorCode, message, System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
