package testTask4;

import testTask4.base.Card;

import java.math.BigDecimal;

public abstract class DebitCard extends Card {
    /**
     * - Карты и вклад имеют параметры: валюта, баланс и название 
     * - Карты содержат методы: пополнение, списание, запрос баланса
     */
    public DebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public abstract boolean adjunction();

    public abstract boolean writeOff();

    public abstract BigDecimal balanceRequest();
}
