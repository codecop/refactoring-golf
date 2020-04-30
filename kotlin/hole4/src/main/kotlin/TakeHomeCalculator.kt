package hole4

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = rest.toList()

        var total = first

        monies.forEach { total += it }

        val amount = total.value * (percent / 100.0)

        val tax = Money(amount.toInt(), first.currency)

        if (total.currency != tax.currency) {
            throw Incalculable()
        }

        return Money(total.value - tax.value, first.currency)
    }

    internal data class Money(val value: Int, val currency: String) {
        operator fun plus(other: Money): Money {
            if (other.currency != currency) {
                throw Incalculable()
            }
            return Money(value + other.value, other.currency)
        }
    }
}
