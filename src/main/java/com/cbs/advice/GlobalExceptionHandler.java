package com.cbs.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cbs.dto.CustomResponse;
import com.cbs.exception.TransactionNotFoundException;
import com.cbs.util.CustomResponseBuilder;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Handles CustomException and generates a custom error response.
	 * 
	 * @param ex The CustomException instance.
	 * @return A ResponseEntity containing a custom error response.
	 */
	@ResponseBody
	@ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<CustomResponse<String>> handleTransactionNotFoundException(TransactionNotFoundException ex) {
		return CustomResponseBuilder.error(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
