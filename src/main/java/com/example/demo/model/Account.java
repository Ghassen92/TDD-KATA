package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {
    private double balance;
    //découvert Bancaire
    private double overdraft;

    public void depositAmount(double amount) {
        balance += amount;
    }

    public void withdrawAmount(double amount) {
        if (balance + overdraft < amount) throw new RuntimeException("Overdraft Depassed");
        balance -= amount;
    }
}