package hole3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Hole 3: Take home calculator should")
public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() {
        Integer first = new TakeHomeCalculator(10).netAmount(
                new TakeHomeCalculator.Money(40, "GBP"),
                new TakeHomeCalculator.Money(50, "GBP"),
                new TakeHomeCalculator.Money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test
    public void not_sum_different_currencies() {
        assertThrows(Incalculable.class, () ->
                new TakeHomeCalculator(10).netAmount(
                        new TakeHomeCalculator.Money(4, "GBP"),
                        new TakeHomeCalculator.Money(5, "USD")
                )
        );
    }
}
