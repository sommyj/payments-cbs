package com.cbs.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbs.dto.CustomResponse;
import com.cbs.dto.TransactionRequest;
import com.cbs.dto.TransactionStatusRequest;
import com.cbs.model.Transaction;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface TransactionControllerApi {
	@Operation(
            summary = "Initiate Transaction",
            description = "Initiate a transaction and save to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful transaction initiation")
    })
	public ResponseEntity<CustomResponse<String>> initTransaction(@AuthenticationPrincipal User user,
            @RequestBody TransactionRequest request);
	
	@Operation(
            summary = "Fetch Transaction",
            description = "Fetch a transaction from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful transaction retrival")
    })
	public ResponseEntity<CustomResponse<Transaction>> getTransaction(@AuthenticationPrincipal User user,
            @PathVariable Long id);
	
	@Operation(
            summary = "Update Transaction Status",
            description = "Update Transaction Status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful transaction update")
    })
	public ResponseEntity<CustomResponse<String>> updateTransactionStatus(@RequestBody TransactionStatusRequest update);
}
