package testTask4.base;

import java.math.BigDecimal;

public abstract class BankProduct {

    private String name;
    private String currency;
    private BigDecimal balance;

    protected BankProduct(String name, String currency, BigDecimal balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }
}
