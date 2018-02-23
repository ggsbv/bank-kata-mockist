package com.codurance.kata.bankaccountmockist;

import java.time.LocalDateTime;

public class Clock {
    public LocalDateTime currentTime() {
        return LocalDateTime.now();
    }
}
