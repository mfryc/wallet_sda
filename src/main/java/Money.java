import exceptions.YouArePoorException;
import exceptions.NotThisCurrencyException;

import java.math.BigDecimal;

import static java.lang.String.format;

public class Money {
    private BigDecimal amount;
    private Currency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money(BigDecimal initialAmount, Currency currency) {
        this.amount = initialAmount;
        this.currency = currency;
    }

    public Money takeTheMoney(Money quantity) {
        checkTheCurrency(quantity);
        this.amount = this.amount.add(quantity.amount);
        return this;
    }

    public Money getTheMoney(Money quantity) throws YouArePoorException {
        checkTheCurrency(quantity);
        if (canYouAfford(quantity)) {
            this.amount = this.amount.subtract(quantity.amount);
            return this;
        } else {
            throw new YouArePoorException();
        }
    }

    public boolean canYouAfford(Money quantity) {
        checkTheCurrency(quantity);
        return this.amount.compareTo(quantity.amount) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.compareTo(money.amount) == 0 &&
                currency == money.currency;
    }

    @Override
    public String toString() {
        return format("%.2f %s", amount, currency);
    }

    private void checkTheCurrency(Money money) {
        if (!currency.equals(money.currency)) {
            throw new NotThisCurrencyException();
        }
    }
}