import com.codurance.kata.bankaccountmockist.Deposit;
import com.codurance.kata.bankaccountmockist.TransactionFormatter;
import com.codurance.kata.bankaccountmockist.Withdrawal;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionFormatterShould {
    private TransactionFormatter transactionFormatter;

    @Before
    public void initialise() {
        transactionFormatter = new TransactionFormatter();
    }

    @Test
    public void
    format_a_deposit_correctly() {
        Deposit deposit = new Deposit(10, LocalDateTime.of(2012, 1, 14, 0, 0), 0);

        assertThat(transactionFormatter.format(deposit), is("14/01/2012 || || 10.00 || 10.00"));
    }

    @Test
    public void
    format_a_withdrawal_correctly() {
        Withdrawal withdrawal = new Withdrawal(10, LocalDateTime.of(2012, 1, 14, 0, 0), 30);

        assertThat(transactionFormatter.format(withdrawal), is("14/01/2012 || 10.00 || || 20.00"));
    }
}
