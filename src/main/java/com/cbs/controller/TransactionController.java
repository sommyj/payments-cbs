package com.cbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.controller.api.TransactionControllerApi;
import com.cbs.dto.CustomResponse;
import com.cbs.dto.TransactionRequest;
import com.cbs.dto.TransactionStatusRequest;
import com.cbs.model.Transaction;
import com.cbs.service.TransactionService;
import com.cbs.util.CustomResponseBuilder;

@RestController
@RequestMapping("/api")
public class TransactionController implements TransactionControllerApi{
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transactions")
    public ResponseEntity<CustomResponse<String>> initTransaction(@AuthenticationPrincipal User user,
                                                      @RequestBody TransactionRequest request) {
		return CustomResponseBuilder.success(transactionService.initTransaction(request), "Transaction successful", HttpStatus.CREATED);
    }
	
    @GetMapping("/transactions/{id}")
    public ResponseEntity<CustomResponse<Transaction>> getTransaction(@AuthenticationPrincipal User user,
                                      @PathVariable Long id) {
    	return CustomResponseBuilder.success(transactionService.getTransaction(id), "Transaction fetch successfully");
    }

    @PostMapping("/webhook/transactions")
    public ResponseEntity<CustomResponse<String>> updateTransactionStatus(@RequestBody TransactionStatusRequest update) {
    	return CustomResponseBuilder.success(transactionService.updateTransactionStatus(update), "Transaction status update successfully");
    }
}
