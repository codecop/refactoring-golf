package hole2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Hole 2: Take home calculator should")
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

    @Test
    public void not_sum_different_currencies() throws Exception {
        assertThrows(Incalculable.class, () ->
                new TakeHomeCalculator(10).netAmount(
                        new TakeHomeCalculator.Pair<>(4, "GBP"),
                        new TakeHomeCalculator.Pair<>(5, "USD")
                )
        );
    }
}
