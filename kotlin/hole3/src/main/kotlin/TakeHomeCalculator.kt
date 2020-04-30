package hole3

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = listOf(*rest)

        var total = first

        monies.forEach {
            if (it.currency != total.currency) {
                throw Incalculable()
            }
        }

        monies.forEach { next ->
            total = Money(total.value + next.value, next.currency)
        }

        val amount = total.value * (percent / 100.0)

        val tax = Money(amount.toInt(), first.currency)

        if (total.currency != tax.currency) {
            throw Incalculable()
        }

        return Money(total.value - tax.value, first.currency)
    }

    internal data class Money(val value: Int, val currency: String)

}
