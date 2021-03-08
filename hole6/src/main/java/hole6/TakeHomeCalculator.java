package hole6;

import static java.util.stream.Stream.of;

class TakeHomeCalculator {

    private final TaxRate taxRate;

    TakeHomeCalculator(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    Money netAmount(Money first, Money... rest) {
        Money total  = of(rest).reduce(first, Money::plus);
        Money tax = taxRate.apply(total);
        return total.minus(tax);
    }
}
