package com.codurance.kata.bankaccountmockist;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    public void store(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> all() {
        return transactions;
    }

}
