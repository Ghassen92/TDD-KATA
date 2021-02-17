package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.EOperation;
import com.example.demo.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void depositAmount_shouldIncreaseBalance_case10() {
        Account account = new Account(0d,0d);
        account.depositAmount(10d);

        assertEquals(10d, account.getBalance());
    }

    @Test
    void depositAmount_shouldIncreaseBalance_case20() {
        Account account = new Account(0d,0d);
        account.depositAmount(20d);

        assertEquals(20d, account.getBalance());
    }

    @Test
    void depositAmount_shouldIncreaseBalance_case50() {
        Account account = new Account(5d,0d);
        account.depositAmount(50d);

        assertEquals(55d, account.getBalance());
    }

    @Test
    void withdrawAmount_shouldDecresaseBalance_caseBalanceGraterThenAmount(){
        Account account =new Account(100d,0d);
        account.withdrawAmount(90d);

        assertEquals(10d,account.getBalance());
    }

    @Test
    void withdrawAmount_shouldThrowException_caseOverdraftDepassed() {
        Account account = new Account( 100d, 200d);
        assertThrows(RuntimeException.class,
                ()->{
                    account.withdrawAmount(400d);
                });

    }

    @Test
    void checkHistory_shouldListDepositOperation() {
        Account account = new Account( 0, 200d);
        Transaction transaction = new Transaction(EOperation.Deposit,new Date(), 100d, 100d);

        account.depositAmount(100d);

        assertNotNull(account.getTransactions());
        assertEquals(transaction, account.getTransactions().get(0));
    }

    @Test
    void checkHistory_shouldListWithDrawOperation() {
        Account account = new Account( 100, 200d);
        Transaction transaction = new Transaction(EOperation.WithDraw,new Date(),150d, -50d);

        account.withdrawAmount(150d);

        assertNotNull(account.getTransactions());
        assertEquals(1, account.getTransactions().size());
        assertEquals(transaction, account.getTransactions().get(0));

    }

    @Test
    void checkHistory_shouldListAllOperationsWithDates() {
        Account account = new Account(0, 200d);
        Transaction transactionDeposit = new Transaction(EOperation.Deposit, new Date(), 100d, 100d);
        Transaction transactionWithDraw = new Transaction(EOperation.WithDraw, new Date(), 40d, 60d);

        account.depositAmount(100);
        account.withdrawAmount(40d);

        assertNotNull(account.getTransactions());
        assertEquals(transactionDeposit.getDate(),account.getTransactions().get(0).getDate());
        assertEquals(Arrays.asList(transactionDeposit, transactionWithDraw), account.getTransactions());
    }
}
