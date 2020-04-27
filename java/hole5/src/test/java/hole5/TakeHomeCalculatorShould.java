package hole5;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hole5.Money.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Hole 5: Take home calculator should")
public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() {
        Integer first = new TakeHomeCalculator(10).netAmount(
                money(40, "GBP"),
                money(50, "GBP"),
                money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test
    public void not_sum_different_currencies() {
        assertThrows(Incalculable.class,
                () -> new TakeHomeCalculator(10).netAmount(
                        money(4, "GBP"),
                        money(5, "USD"))
        );
    }
}
