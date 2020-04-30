package hole2

import hole2.TakeHomeCalculator.Pair
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("Hole 2: Take home calculator should")
class TakeHomeCalculatorShould {

    @Test
    fun `calculate tax`() {
        val first = TakeHomeCalculator(10).netAmount(
                Pair(40, "GBP"),
                Pair(50, "GBP"),
                Pair(60, "GBP")
        ).first
        assertEquals(135, first)
    }

    @Test
    fun `not sum different currencies`() {
        assertThrows<Incalculable> {
            TakeHomeCalculator(10).netAmount(
                    Pair(4, "GBP"),
                    Pair(5, "USD")
            )
        }
    }
}
