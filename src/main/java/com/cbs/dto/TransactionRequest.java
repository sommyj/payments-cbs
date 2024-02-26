package com.cbs.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
	private double amount;
	private String cardNumber;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date expiryDate;
	private String cvv;
}
