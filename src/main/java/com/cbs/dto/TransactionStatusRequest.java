package com.cbs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionStatusRequest {
	private String transactionId;
    private String status;
}
