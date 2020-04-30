package hole5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("Hole 5: Take home calculator should")
class TakeHomeCalculatorShould {
    @Test
    fun `calculate tax`() {
        val first = TakeHomeCalculator(10).netAmount(
                Money(40, "GBP"),
                Money(50, "GBP"),
                Money(60, "GBP")
        ).value
        assertEquals(135, first)
    }

    @Test
    fun `not sum different currencies`() {
        assertThrows<Incalculable> {
            TakeHomeCalculator(10).netAmount(
                    Money(4, "GBP"),
                    Money(5, "USD")
            )
        }
    }
}
