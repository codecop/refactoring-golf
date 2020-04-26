package hole6

import hole6.Money.Companion.money
import hole6.TaxRate.Companion.taxRate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("Hole 7: Take home calculator should")
class TakeHomeCalculatorShould {
    @Test
    fun `calculate tax`() {
        val first = TakeHomeCalculator(taxRate(10)).netAmount(
                money(40, "GBP"),
                money(50, "GBP"),
                money(60, "GBP")
        ).value
        assertEquals(135, first)
    }

    @Test
    fun `not sum different currencies`() {
        assertThrows<Incalculable> {
            TakeHomeCalculator(taxRate(10)).netAmount(
                    money(4, "GBP"),
                    money(5, "USD")
            )
        }
    }
}
