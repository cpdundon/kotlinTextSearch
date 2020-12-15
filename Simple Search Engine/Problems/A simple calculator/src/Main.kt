import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val firstLong = scanner.nextLong()
    val operator = scanner.next().trim(' ')
    val secondLong = scanner.nextLong()

    if (operator == "/" && secondLong == 0L) {
        println("Division by 0!")
        return
    }

    when (operator) {
        "+" -> println(firstLong + secondLong)
        "-" -> println(firstLong - secondLong)
        "*" -> println(firstLong * secondLong)
        "/" -> println(firstLong / secondLong)
        else -> println("Unknown operator")
    }
}