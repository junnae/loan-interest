import java.time.YearMonth
import kotlin.math.round

class PaymentPlan(
    amount: Double,
    start: YearMonth,
    years: Int,
    yearlyInterest: Number
) {
    private val PAYMENTS_PER_YEAR = 12
    private val monthlyInterest = yearlyInterest.toDouble() / PAYMENTS_PER_YEAR
    internal val plan: MutableMap<YearMonth, Payment> = calculatePlan(amount, years, start, monthlyInterest)

    override fun toString(): String {
        return plan.map {
            "${it.key}: ${it.value}"
        }.joinToString("\n")
    }
}

internal data class Payment(val principal: Double, val interest: Double) {
    val total: Double
        get() = principal + interest
}

internal fun calculatePlan(amount: Double, years: Int, start: YearMonth, monthlyInterest: Double): MutableMap<YearMonth, Payment> {
    val plan: MutableMap<YearMonth, Payment> = mutableMapOf()
    val monthlyAmount = round(amount / years / 12.0) //We'll simplify rounding for now
    var remaingMonths = years * 12
    var unpaidAmount = amount
    var currentMonth = start;
    while (remaingMonths-- > 0) {
        plan[currentMonth] = Payment(monthlyAmount, round(((monthlyInterest / 100) * unpaidAmount)))
        currentMonth = currentMonth.plusMonths(1)
        unpaidAmount -= monthlyAmount;
    }
    return plan
}

