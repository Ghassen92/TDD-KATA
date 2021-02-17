package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Transaction {
    private EOperation operation;
    private double amount;
    private double balance;
}

