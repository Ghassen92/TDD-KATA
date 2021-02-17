package com.example.demo;

import com.example.demo.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
