package testTask4.base;

import java.math.BigDecimal;

public abstract class Card extends BankProduct implements IBankProduct{

    public Card(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public abstract boolean adjunction();

    public abstract boolean writeOff();

    public abstract BigDecimal balanceRequest();
}
