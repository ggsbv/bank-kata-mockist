package com.codurance.kata.bankaccountmockist;

import java.time.LocalDateTime;
import java.util.Objects;

public class Withdrawal implements Transaction {
    private final int amount;
    private final LocalDateTime createdAt;
    private final int balanceAfter;

    public Withdrawal(int amount, LocalDateTime createdAt, int balance) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.balanceAfter = balance - amount;
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
        Withdrawal that = (Withdrawal) o;
        return amount == that.amount &&
                balanceAfter == that.balanceAfter &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, createdAt, balanceAfter);
    }
}
