package com.intern.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void getBalanceOk() throws Exception {
        long balance = 1000;
        Account account = new Account(balance);
        long result = account.getBalance();

        assertEquals(balance, result);
    }

    @Test
    public void withdrawTest() throws Exception {
        long balance = 1000;
        long amount = 700;
        long newBalance = balance - amount;
        Account account = new Account(balance);
        account.withdraw(amount);
        long result = account.getBalance();

        assertEquals(newBalance, result);
    }
}
