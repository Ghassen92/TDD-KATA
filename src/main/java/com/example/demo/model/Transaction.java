package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Transaction {
    private EOperation operation;
    private Date date;
    private double amount;
    private double balance;
}

