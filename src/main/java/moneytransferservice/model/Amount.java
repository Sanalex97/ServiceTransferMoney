package moneytransferservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Amount {
    @Min(1)
    @NotBlank
    private Integer value;
    private Currency currency;

    @Override
    public String toString() {
        return value + " " + currency;
    }

    public Amount(Integer value, Currency currency) {
        this.value = value / 100;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getValue() {
        return value;
    }
}
