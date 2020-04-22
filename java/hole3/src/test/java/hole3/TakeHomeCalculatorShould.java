package hole3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() throws Exception {
        Integer first = new TakeHomeCalculator(10).netAmount(
                new TakeHomeCalculator.Money(40, "GBP"),
                new TakeHomeCalculator.Money(50, "GBP"),
                new TakeHomeCalculator.Money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void not_sum_different_currencies() throws Exception {
        new TakeHomeCalculator(10).netAmount(
                new TakeHomeCalculator.Money(4, "GBP"),
                new TakeHomeCalculator.Money(5, "USD")
        );
    }
}
