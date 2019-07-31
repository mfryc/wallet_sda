import exceptions.YouArePoorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet wallet;

    @BeforeEach
    public void createWallet() {
        wallet = new Wallet();
    }


    @Test
    public void deposit() {
        BigDecimal quantity = new BigDecimal(20.99);
        Money quantityPLN = new Money(quantity, Currency.PLN);
        wallet.deposit(quantityPLN);
        assertEquals(quantityPLN, wallet.getMoney().get(Currency.PLN));
    }

    @Test
    public void withdraw() throws YouArePoorException {
        //is
        BigDecimal amountPaidIn = BigDecimal.valueOf(2099, 2);
        BigDecimal amountPaidOut = new BigDecimal(10);
        BigDecimal expectedAmount = BigDecimal.valueOf(1099, 2);

        Money expectedPLN = new Money(expectedAmount, Currency.PLN);
        Money PlnPaidIn = new Money(amountPaidIn, Currency.PLN);
        wallet.deposit(PlnPaidIn);
        Money PlnPaidOut = new Money(amountPaidOut, Currency.PLN);

        //then
        wallet.withdraw(PlnPaidOut);

        //expected
        assertEquals(expectedPLN, wallet.getMoney().get(Currency.PLN));

    }
}