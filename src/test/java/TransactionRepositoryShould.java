import com.codurance.kata.bankaccountmockist.Deposit;
import com.codurance.kata.bankaccountmockist.Transaction;
import com.codurance.kata.bankaccountmockist.TransactionRepository;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionRepositoryShould {

    @Test
    public void
    return_all_transactions() {
        TransactionRepository transactionRepository = new TransactionRepository();
        Deposit deposit = new Deposit(10, LocalDateTime.now(), 10);
        List<Transaction> expected = asList(deposit);

        transactionRepository.store(deposit);

        assertThat(transactionRepository.all(), is(expected));
    }
}
