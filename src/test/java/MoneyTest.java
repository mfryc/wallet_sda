import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    void checkPrzyjmijPieniadze() {
        Money p1 = new Money(new BigDecimal(30), Currency.PLN);
        Money p2 = new Money(new BigDecimal(350), Currency.PLN);

        p1.takeTheMoney(p2);
        assertEquals(p1.getAmount(), new BigDecimal(380));
    }


    @ParameterizedTest
    @CsvSource({"7, PLN, true", "10.00000, PLN, true", "25, PLN, false"})
    public void checkCzyCieStac(String kwota, Currency currency, boolean result) {
        Money a = new Money(BigDecimal.TEN, Currency.PLN);
        Money b = new Money(new BigDecimal(kwota), currency);

        assertEquals(result, a.canYouAfford(b));
    }
}