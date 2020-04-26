package hole1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("Hole 1: Take home calculator should")
class TakeHomeCalculatorShould {

    @Test
    fun `calculate tax`() {
        val first = TakeHomeCalculator(10).netAmount(
                TakeHomeCalculator.Pair(40, "GBP"),
                TakeHomeCalculator.Pair(50, "GBP"),
                TakeHomeCalculator.Pair(60, "GBP")
        ).first
        assertEquals(135, first)
    }

    @Test
    fun `not sum different currencies`() {
        assertThrows<Incalculable> {
            TakeHomeCalculator(10).netAmount(
                    TakeHomeCalculator.Pair(4, "GBP"),
                    TakeHomeCalculator.Pair(5, "USD")
            )
        }
    }
}
