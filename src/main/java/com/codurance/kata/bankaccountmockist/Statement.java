package com.codurance.kata.bankaccountmockist;

import java.util.Comparator;
import java.util.List;

public class Statement {
    private static final String HEADER = "date || credit || debit || balance";
    private Output output;
    private TransactionFormatter transactionFormatter;

    public Statement(Output output, TransactionFormatter transactionFormatter) {
        this.output = output;
        this.transactionFormatter = transactionFormatter;
    }

    public void print(List<Transaction> transactions) {
        output.print(formattedStatementFor(transactions));
    }

    private String formattedStatementFor(List<Transaction> transactions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::createdAt).reversed())
                .forEach((Transaction transaction) -> {
                    stringBuilder.append("\n");
                    stringBuilder.append(transactionFormatter.format(transaction));
                });

        return stringBuilder.toString();
    }
}
