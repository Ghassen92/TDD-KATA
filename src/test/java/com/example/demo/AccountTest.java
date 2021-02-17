package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.EOperation;
import com.example.demo.model.Transaction;
import org.junit.jupiter.api.Test;

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
        Transaction transaction = new Transaction(EOperation.Deposit, 100d, 100d);

        account.depositAmount(100d);

        assertNotNull(account.getTransactions());
        assertEquals(transaction, account.getTransactions().get(0));
    }

    @Test
    void checkHistory_shouldListWithDrawOperation() {
        Account account = new Account( 100, 200d);
        Transaction transaction = new Transaction(EOperation.WithDraw, 150d, -50d);

        account.depositAmount(150d);

        assertNotNull(account.getTransactions());
        assertEquals(1, account.getTransactions().size());
        assertEquals(transaction, account.getTransactions().get(0));

    }
}
