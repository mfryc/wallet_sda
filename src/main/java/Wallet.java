import exceptions.YouArePoorException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Wallet {
    private Map<Currency, Money> money;

    public Wallet() {
        money = new HashMap<Currency, Money>();
    }

    public void deposit(Money quantity) {
        if (!money.containsKey(quantity.getCurrency())) {
            money.put(quantity.getCurrency(), new Money(new BigDecimal(0), quantity.getCurrency()));
        }
        money.get(quantity.getCurrency()).takeTheMoney(quantity);
    }

    public void withdraw(Money quantity) throws YouArePoorException {
        money.get(quantity.getCurrency()).getTheMoney(quantity);
    }

    public String balance() {
        return format("Balance: %s", money);
    }

    public Map<Currency, Money> getMoney() {
        return money;
    }
}