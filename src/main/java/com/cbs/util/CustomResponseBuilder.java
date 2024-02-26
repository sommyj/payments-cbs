package com.cbs.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cbs.dto.CustomResponse;

public class CustomResponseBuilder {
	
	/**
     * Creates a ResponseEntity for a successful response with the specified data and message.
     *
     * @param data    The data to include in the response.
     * @param message The response message.
     * @param <T>     The type of the data.
     * @param code    The HTTP status code.
     * @return A ResponseEntity containing a successful response with a custom message.
     */
    public static <T> ResponseEntity<CustomResponse<T>> success(T data, String message, HttpStatus code) {
        CustomResponse<T> customResponse = new CustomResponse<>();
        customResponse.setMessage(message);
        customResponse.setData(data);

        return new ResponseEntity<>(customResponse, code);
    }
    
    /**
     * Creates a ResponseEntity for a successful response with the specified data and message.
     *
     * @param data    The data to include in the response.
     * @param message The response message.
     * @param <T>     The type of the data.
     * @return A ResponseEntity containing a successful response with a custom message.
     */
    public static <T> ResponseEntity<CustomResponse<T>> success(T data, String message) {
        CustomResponse<T> customResponse = new CustomResponse<>();
        customResponse.setMessage(message);
        customResponse.setData(data);

        return ResponseEntity.ok(customResponse);
    }
    
    /**
     * Creates a ResponseEntity for an error response with the specified message and HTTP status code.
     *
     * @param message The error message.
     * @param code    The HTTP status code.
     * @param <T>     The type of the response data.
     * @return A ResponseEntity containing an error response.
     */
    public static <T> ResponseEntity<CustomResponse<T>> error(String message, HttpStatus code) {
        CustomResponse<T> customResponse = new CustomResponse<>();
        customResponse.setMessage(message);

        return new ResponseEntity<>(customResponse, code);
    }

}
