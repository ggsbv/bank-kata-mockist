package com.codurance.kata.bankaccountmockist;

public class BankAccount {
    private TransactionRepository transactionRepository;
    private Clock clock;
    private Balance balance;
    private Statement statement;

    public BankAccount(TransactionRepository transactionRepository, Clock clock, Statement statement) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.balance = new Balance();
        this.statement = statement;
    }

    public void deposit(int amount) {
        transactionRepository.store(new Deposit(amount, clock.currentTime(), balance()));
    }

    public void withdraw(int amount) {
        transactionRepository.store(new Withdrawal(amount, clock.currentTime(), balance()));
    }

    private int balance() {
        return balance.calculate(transactionRepository.all());
    }

    public void statement() {
        statement.print(transactionRepository.all());
    }
}
