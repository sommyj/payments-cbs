package com.cbs.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Transaction {
    private long id;
    private double amount;
    private String cardNumber;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date expiryDate;
    private String cvv;
    private String status;
}
