package hole6

import hole6.Money.Companion.money

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val taxRate: TaxRate) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies: List<Money> = listOf(*rest)

        var total = first

        for (next in monies) {
            total = total.plus(next)
        }

        val tax: Money = taxRate.apply(total)

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

internal class TaxRate private constructor(private val percent: Int) {
    fun apply(total: Money): Money {
        val amount = total.value * (percent / 100.0)
        return money(amount.toInt(), total.currency)
    }

    companion object {
        fun taxRate(percent: Int): TaxRate {
            return TaxRate(percent)
        }
    }
}
