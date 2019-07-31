import exceptions.YouArePoorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet wallet;
    @BeforeEach
    public void stworzPortfel() {
        wallet = new Wallet();
    }


    @Test
    public void wplac () {
        BigDecimal kwota = new BigDecimal(20.99);
        Money zlotowkiWplacane = new Money(kwota, Currency.PLN);
        wallet.deposit(zlotowkiWplacane);
        assertEquals(zlotowkiWplacane, wallet.getMoney().get(Currency.PLN));
    }

    @Test
    public void wyplac () throws YouArePoorException {
        //is
        BigDecimal kwotaWplacona = BigDecimal.valueOf(2099,2);
        BigDecimal kwotaWyplacona = new BigDecimal(10);
        BigDecimal kwotaSpodziewana = BigDecimal.valueOf(1099,2);

        Money zlotowkiSpodziewane = new Money(kwotaSpodziewana, Currency.PLN);
        Money zlotowkiWplacane = new Money(kwotaWplacona, Currency.PLN);
        wallet.deposit(zlotowkiWplacane);
        Money zlotowkiWyplacone = new Money(kwotaWyplacona, Currency.PLN);

        //then
        wallet.withdraw(zlotowkiWyplacone);

        //expected
        assertEquals(zlotowkiSpodziewane, wallet.getMoney().get(Currency.PLN));

    }

    @Test
    public void saldo () {


    }
}