package hole1

class Incalculable : Throwable()

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Pair<Int, String>, vararg rest: Pair<Int, String>): Pair<Int, String> {
        val pairs: List<Pair<Int, String>> = rest.toList()

        var total = first

        pairs.forEach {
            if (!it.second.equals(total.second)) {
                throw Incalculable()
            }
        }

        pairs.forEach {
            total = Pair(total.first + it.first, it.second)
        }

        val amount = total.first * (percent / 100.0)

        val tax = Pair(amount.toInt(), first.second)

        return if (total.second.equals(tax.second)) {
            Pair(total.first - tax.first, first.second)
        } else {
            throw Incalculable()
        }
    }

    internal data class Pair<A, B>(val first: A, val second: B)
}

