package com.codurance.kata.bankaccountmockist;

import java.time.LocalDateTime;
import java.util.Objects;

public class Deposit implements Transaction {
    private int amount;
    private LocalDateTime createdAt;
    private int balanceAfter;

    public Deposit(int amount, LocalDateTime createdAt, int balance) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.balanceAfter = amount + balance;
    }

    public int amount() {
        return amount;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public int balanceAfter() {
        return balanceAfter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return amount == deposit.amount &&
                Objects.equals(createdAt, deposit.createdAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, createdAt);
    }
}
