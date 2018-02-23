package com.codurance.kata.bankaccountmockist;

import java.util.List;

public class Balance {
    public int calculate(List<Transaction> transactions) {
        int balance = 0;

        for (Transaction transaction: transactions) {
            if (isADeposit(transaction))
                balance += transaction.amount();

            if (isAWithdrawal(transaction))
                balance -= transaction.amount();
        }

        return balance;
    }

    private boolean isAWithdrawal(Transaction transaction) {
        return transaction instanceof Withdrawal;
    }

    private boolean isADeposit(Transaction transaction) {
        return transaction instanceof Deposit;
    }
}
