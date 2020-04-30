package hole5

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = rest.toList()

        var total = first

        monies.forEach { total = total.plus(it) }

        val amount = total.value * (percent / 100.0)

        val tax = Money(amount.toInt(), first.currency)

        return total.minus(tax)
    }
}

internal data class Money(val value: Int, val currency: String) {
    fun plus(other: Money): Money {
        if (other.currency != currency) {
            throw Incalculable()
        }
        return Money(value + other.value, other.currency)
    }

    fun minus(other: Money): Money {
        if (currency != other.currency) {
            throw Incalculable()
        }
        return Money(value - other.value, currency)
    }
}
