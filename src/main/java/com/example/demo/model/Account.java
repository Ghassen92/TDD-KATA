package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.model.EOperation.Deposit;
import static com.example.demo.model.EOperation.WithDraw;

@Getter
public class Account {
    private double balance;
    //découvert Bancaire
    private double overdraft;
    private List<Transaction> transactions=new ArrayList<>();

    public Account(double balance, double overdraft) {
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public void depositAmount(double amount) {
        balance += amount;
        transactions.add(new Transaction(Deposit,new Date(), amount, balance));
    }

    public void withdrawAmount(double amount) {
        if (balance + overdraft < amount) throw new RuntimeException("Overdraft Depassed");
        balance -= amount;
        transactions.add(new Transaction( WithDraw,new Date(), amount, balance));
    }
}