package com.codurance.kata.bankaccountmockist;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TransactionFormatter {
    public String format(Transaction transaction) {
        return String.format(
                Locale.ROOT,
                formatFor(transaction),
                transaction.createdAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                (float) transaction.amount(),
                (float) transaction.balanceAfter()
        );
    }

    private String formatFor(Transaction transaction) {
        if (transaction instanceof Withdrawal)
                return "%s || %.2f || || %.2f";
        if (transaction instanceof Deposit)
                return "%s || || %.2f || %.2f";

        return "";
    }
}
