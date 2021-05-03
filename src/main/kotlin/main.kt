import Loan.Companion.housingLoan
import java.time.YearMonth

fun main() {
    println("Hi there..!")
    println("...")
    Thread.sleep(2000)
    println("How much would you like to borrow?")
    val amount: Int = readLine()!!.toInt()
    println("Okay..")
    Thread.sleep(2000)
    println("How many years do you need to pay off your loan?")
    val years: Int = readLine()!!.toInt()
    println("Calculating..")
    Thread.sleep(2000)

    print(housingLoan(amount, years, YearMonth.now().plusMonths(1)).toString())

}
