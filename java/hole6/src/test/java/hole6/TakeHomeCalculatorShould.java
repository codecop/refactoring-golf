package hole6;

import org.junit.Test;

import static hole6.Money.money;
import static hole6.TaxRate.taxRate;
import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() throws Exception {
        Integer first = new TakeHomeCalculator(taxRate(10)).netAmount(
                money(40, "GBP"),
                money(50, "GBP"),
                money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void not_sum_different_currencies() throws Exception {
        new TakeHomeCalculator(taxRate(10)).netAmount(
                money(4, "GBP"),
                money(5, "USD")
        );
    }
}
