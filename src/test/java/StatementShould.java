import com.codurance.kata.bankaccountmockist.Output;
import com.codurance.kata.bankaccountmockist.Statement;
import com.codurance.kata.bankaccountmockist.Transaction;
import com.codurance.kata.bankaccountmockist.TransactionFormatter;
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
public class StatementShould {
    private static final List<Transaction> NO_TRANSACTIONS = emptyList();
    private Statement statement;

    @Mock
    private Output output;

    @Mock
    private TransactionFormatter formatter;

    @Mock
    private Transaction transaction, earlierTransaction;

    @Before
    public void initialise() {
        statement = new Statement(output, formatter);
    }

    @Test
    public void
    print_an_empty_statement() {
        statement.print(NO_TRANSACTIONS);

        verify(output).print("date || credit || debit || balance");
    }

    @Test
    public void
    print_a_formatted_transaction() {
        Statement statement = new Statement(output, formatter);
        when(formatter.format(transaction)).thenReturn("a formatted transaction");

        statement.print(asList(transaction));

        verify(output).print("date || credit || debit || balance\n" +
                "a formatted transaction");
    }

    @Test
    public void
    print_formatted_transactions_in_descending_order() {
        LocalDateTime currentTime = LocalDateTime.now();

        when(transaction.createdAt()).thenReturn(currentTime);
        when(earlierTransaction.createdAt()).thenReturn(currentTime.minusSeconds(1));

        when(formatter.format(transaction)).thenReturn("later transaction");
        when(formatter.format(earlierTransaction)).thenReturn("earlier transaction");

        statement.print(asList(earlierTransaction, transaction));

        verify(output).print("date || credit || debit || balance\n" +
                "later transaction\n" +
                "earlier transaction");
    }
}
