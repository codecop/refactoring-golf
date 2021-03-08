package hole5;

import static hole5.Money.money;

public class TaxRate {
    private final int percent;

    private TaxRate(int percent) {
        this.percent = percent;
    }

    public static TaxRate taxRate(int percent) {
        return new TaxRate(percent);
    }

    public int getPercent() {
        return percent;
    }

    public Money apply(Money total) {
        Double amount = total.value * (getPercent() / 100d);
        return money(amount.intValue(), total.currency);
    }
}
