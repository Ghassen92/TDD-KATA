package com.example.demo;

import com.example.demo.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void depositAmount_shouldIncreaseBalance_case10(){
        Account account =new Account(0d);
        account.depositAmount(10d);

        assertEquals(10d,account.getBalance());
    }
}
