package com.codurance.kata.bankaccountmockist;
import java.time.LocalDateTime;

public interface Transaction {
    int amount();

    LocalDateTime createdAt();

    int balanceAfter();
}
