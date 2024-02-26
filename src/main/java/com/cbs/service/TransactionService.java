package com.cbs.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.cbs.dto.TransactionRequest;
import com.cbs.dto.TransactionStatusRequest;
import com.cbs.exception.TransactionNotFoundException;
import com.cbs.model.Transaction;

@Service
public class TransactionService {

	private final Map<Long, Transaction> transactions = new ConcurrentHashMap<>();

	public String initTransaction(TransactionRequest request) {
		long transactionId = System.currentTimeMillis();
		transactions.put(transactionId,
				Transaction.builder().id(transactionId).amount(request.getAmount()).cardNumber(request.getCardNumber())
						.expiryDate(request.getExpiryDate()).cvv(request.getCvv()).status("pending").build());
		return String.valueOf(transactionId);
	}

	public Transaction getTransaction(Long id) {
		Transaction transaction = transactions.get(id);
		if (transaction == null) {
			throw new TransactionNotFoundException("Transaction not found");
		}
		return transaction;
	}

	public String updateTransactionStatus(TransactionStatusRequest statusRequest) {
		Transaction transaction = transactions.get(Long.parseLong(statusRequest.getTransactionId()));
		if (transaction == null) {
			throw new TransactionNotFoundException("Transaction not found");
		}
		transaction.setStatus(statusRequest.getStatus());

		return String.valueOf(statusRequest.getTransactionId());
	}

}
