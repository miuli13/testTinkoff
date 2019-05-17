package testTask4;

import testTask4.base.Card;

import java.math.BigDecimal;

public abstract class CreditCard extends Card {

    /**
     * - Карты и вклад имеют параметры: валюта, баланс и название 
     * - Карты содержат методы: пополнение, списание, запрос баланса
     * - Кредитная карта имеет дополнительный метод запрос задолженности и дополнительный параметр процентная ставка
     */

    private BigDecimal interestRate;

    public CreditCard(String name, String currency, BigDecimal balance, BigDecimal interestRate) {
        super(name, currency, balance);
        this.interestRate = interestRate;
    }

    public abstract boolean adjunction();

    public abstract boolean writeOff();

    public abstract BigDecimal balanceRequest();

    public abstract BigDecimal debtRequest();
}

