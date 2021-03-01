import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithATM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends BaseBankAccountTest {
    private SimpleBankAccountWithATM bankAccountWithATM;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithATM(0, accountHolder);
        this.bankAccountWithATM = new SimpleBankAccountWithATM(0, accountHolder);
    }

    @Test
    void testDepositATM() {
        bankAccountWithATM.depositATM(accountHolder.getId(), 100);
        assertEquals(99, bankAccountWithATM.getBalance());
    }

    @Test
    void testWrongDepositATM() {
        bankAccountWithATM.depositATM(accountHolder.getId(), 100);
        bankAccountWithATM.depositATM(2, 50);
        assertEquals(99, bankAccountWithATM.getBalance());
    }

    @Test
    void testWithdrawATM() {
        bankAccountWithATM.depositATM(accountHolder.getId(), 100);
        bankAccountWithATM.withdrawATM(accountHolder.getId(), 70);
        assertEquals(28, bankAccountWithATM.getBalance());
    }

    @Test
    void testWrongWithdrawATM() {
        bankAccountWithATM.depositATM(accountHolder.getId(), 100);
        bankAccountWithATM.withdrawATM(2, 70);
        assertEquals(99, bankAccountWithATM.getBalance());
    }

}
