package hole5

import hole5.Money.Companion.money

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = listOf(*rest)

        var total: Money = first

        for (next in monies) {
            total = total.plus(next)
        }

        val amount: Double = total.value * (percent / 100.0)

        val tax: Money = money(amount.toInt(), first.currency)

        return total.minus(tax)
    }
}


internal class Money private constructor(val value: Int, val currency: String) {
    operator fun plus(other: Money): Money {
        if (other.currency != currency) {
            throw Incalculable()
        }
        return money(value + other.value, other.currency)
    }

    operator fun minus(other: Money): Money {
        if (currency != other.currency) {
            throw Incalculable()
        }
        return money(value - other.value, currency)
    }

    companion object {
        fun money(value: Int, currency: String): Money {
            return Money(value, currency)
        }
    }

}
