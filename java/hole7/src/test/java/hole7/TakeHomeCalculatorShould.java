package hole7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hole7.Money.money;
import static hole7.TaxRate.taxRate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Hole 7: Take home calculator should")
public class TakeHomeCalculatorShould {

    @Test
    public void calculate_tax() {
        Integer first = new TakeHomeCalculator(taxRate(10)).netAmount(
                money(40, "GBP"),
                money(50, "GBP"),
                money(60, "GBP")
        ).value;
        assertEquals(135, first.intValue());
    }

    @Test
    public void not_sum_different_currencies() {
        assertThrows(Incalculable.class, () ->
                new TakeHomeCalculator(taxRate(10)).netAmount(
                        money(4, "GBP"),
                        money(5, "USD"))
        );
    }
}
