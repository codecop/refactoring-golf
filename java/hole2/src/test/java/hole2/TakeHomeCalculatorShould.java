package hole2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() throws Exception {
        Integer first = new TakeHomeCalculator(10).netAmount(
                new TakeHomeCalculator.Pair<>(40, "GBP"),
                new TakeHomeCalculator.Pair<>(50, "GBP"),
                new TakeHomeCalculator.Pair<>(60, "GBP")
        ).first;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void not_sum_different_currencies() throws Exception {
        new TakeHomeCalculator(10).netAmount(
                new TakeHomeCalculator.Pair<>(4, "GBP"),
                new TakeHomeCalculator.Pair<>(5, "USD")
        );
    }
}
