import exceptions.YouArePoorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

public class Person {
    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    private String name;
    private Wallet wallet;

    public Person(String name) {
        this.wallet = new Wallet();
        this.name = name;
    }

    public boolean doYouHaveWallet() {
        if (wallet == null) {
            return false;
        }
        return true;
    }

    public void pay(Person who, Money quantity) {
        try {
            wallet.withdraw(quantity);
            who.take(quantity);
        } catch (YouArePoorException e) {
            LOGGER.warn("You are poor");
        }
    }

    public void take(Money quantity) {
        wallet.deposit(quantity);
    }

    public void audit() {
        LOGGER.info(format("I am %s", name));
        LOGGER.info(wallet.balance());
    }
}