package com.cbs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sommy
 * 
 * Represents a custom response containing response message, and data
 *
 * @param <T> Type of object passed to the response
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse<T> {
		private String message;
		private T data;
		private T error;
}
