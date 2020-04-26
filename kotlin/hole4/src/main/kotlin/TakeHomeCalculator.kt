package hole4

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = listOf(*rest)

        var total = first

        for (next in monies) {
            total = total.plus(next)
        }

        val amount = total.value * (percent / 100.0)

        val tax = Money(amount.toInt(), first.currency)

        if (total.currency != tax.currency) {
            throw Incalculable()
        }

        return Money(total.value - tax.value, first.currency)
    }

    internal class Money(val value: Int, val currency: String) {
        operator fun plus(other: Money): Money {
            if (other.currency != currency) {
                throw Incalculable()
            }
            return Money(value + other.value, other.currency)
        }

    }

}

