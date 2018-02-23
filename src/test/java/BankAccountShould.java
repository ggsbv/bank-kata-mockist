import com.codurance.kata.bankaccountmockist.BankAccount;
import com.codurance.kata.bankaccountmockist.Clock;
import com.codurance.kata.bankaccountmockist.Deposit;
import com.codurance.kata.bankaccountmockist.Statement;
import com.codurance.kata.bankaccountmockist.Transaction;
import com.codurance.kata.bankaccountmockist.TransactionRepository;
import com.codurance.kata.bankaccountmockist.Withdrawal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountShould {
    private BankAccount bankAccount;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private Clock clock;

    @Mock
    private Statement statement;

    @Before
    public void initialise() {
        bankAccount = new BankAccount(transactionRepository, clock, statement);
    }

    @Test
    public void
    handle_a_deposit() {
        int amount = 100;
        int balance = 0;
        LocalDateTime createdAt = LocalDateTime.now();
        when(clock.currentTime()).thenReturn(createdAt);
        when(transactionRepository.all()).thenReturn(emptyList());

        bankAccount.deposit(amount);

        Deposit deposit = new Deposit(amount, createdAt, balance);
        verify(transactionRepository).store(deposit);
    }

    @Test
    public void
    handle_a_withdrawal() {
        int amount = 100;
        int balance = 0;
        LocalDateTime createdAt = LocalDateTime.now();
        when(clock.currentTime()).thenReturn(createdAt);
        when(transactionRepository.all()).thenReturn(emptyList());

        bankAccount.withdraw(amount);

        Withdrawal withdrawal = new Withdrawal(amount, createdAt, balance);
        verify(transactionRepository).store(withdrawal);
    }
    
    @Test
    public void
    print_a_statement() {
        List<Transaction> transactions = asList(new Deposit(100, clock.currentTime(), 0));
        when(transactionRepository.all()).thenReturn(transactions);

        bankAccount.statement();

        verify(statement).print(transactions);
    }
}

