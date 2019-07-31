import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Person person1 = new Person("Franciszek");
        Person person2 = new Person("Zenon");
        Person person3 = new Person("Marek");

        person1.take(new Money(BigDecimal.TEN, Currency.PLN));
        person3.take(new Money(new BigDecimal(20), Currency.EUR));

        person1.audit();
        person2.audit();
        LOGGER.info("Audits have been issued");

        person1.pay(person2, new Money(new BigDecimal(20), Currency.PLN));

        person1.audit();
        person2.audit();
        LOGGER.info("Audits have been issued");


    }
}
