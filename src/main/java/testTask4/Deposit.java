package testTask4;

import testTask4.base.BankProduct;
import testTask4.base.IBankProduct;

import java.math.BigDecimal;

public abstract class Deposit extends BankProduct implements IBankProduct {
    /**
     * - Карты и вклад имеют параметры: валюта, баланс и название 
     * - Вклад содержит методы: пополнение, запрос баланса, закрытие
     */
    Deposit(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public abstract boolean adjunction();

    public abstract BigDecimal balanceRequest();

    public abstract boolean close();
}
