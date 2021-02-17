package com.example.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Transaction {
    private EOperation operation;
    private double amount;
    private double balance;
}

