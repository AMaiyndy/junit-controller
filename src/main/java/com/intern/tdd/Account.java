package com.intern.tdd;

public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        this.balance -= amount;
    }
}
