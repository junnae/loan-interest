import java.time.YearMonth

internal class Loan private constructor(
    amount: Number,
    start: YearMonth,
    years: Int,
    yearlyInterest: Double,
    private val loanType: String
) {
    private val paymentPlan = PaymentPlan(amount.toDouble(), start, years, yearlyInterest)

    companion object {
        fun housingLoan(amount: Int, years: Int, start: YearMonth) = Loan(amount, start, years, 3.5, "Housing loan")
    }

    override fun toString(): String {
        return """$loanType
        PaymentPlan: $paymentPlan
        """
    }
}
