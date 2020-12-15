import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val inNum = scanner.nextLine()
    val intChars = inNum.toCharArray()

    var diff = 0
    for (i in 0 .. 2) {
        diff += (Character.getNumericValue(intChars[i])
                - Character.getNumericValue(intChars[i+3]))
    }

    if (diff == 0) {
        println("Lucky")
    } else {
        println("Regular")
    }
}