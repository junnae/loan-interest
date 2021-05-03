import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.YearMonth

internal class PaymentPlanTest {

    @Test
    fun basicPaymentPlan() {
        val paymentPlan = PaymentPlan(12000.0, YearMonth.of(2021, 1), 1, 12).plan
        assertEquals(12, paymentPlan.size)
        assertTrue(paymentPlan.values.all { it.principal == 1000.0 })
        assertEquals(120.0, paymentPlan.values.first().interest)
        assertEquals(1120.0, paymentPlan.values.first().total)
        assertEquals(YearMonth.of(2021,1), paymentPlan.keys.first())
        assertEquals(10.0, paymentPlan.values.last().interest)
        assertEquals(YearMonth.of(2021,12), paymentPlan.keys.last())
    }

}
