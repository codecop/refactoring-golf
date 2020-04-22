package hole5;

import org.junit.Test;

import static hole5.Money.*;
import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() throws Exception {
        Integer first = new TakeHomeCalculator(10).netAmount(
                money(40, "GBP"),
                money(50, "GBP"),
                money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void not_sum_different_currencies() throws Exception {
        new TakeHomeCalculator(10).netAmount(money(4, "GBP"), money(5, "USD"));
    }
}
