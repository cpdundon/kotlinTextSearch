import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val inpLetters = scanner.nextLine()
    val charArray = inpLetters.toCharArray()

    val baseASCII = charArray[0].toInt()
    var success = true
    for (i in charArray.indices) {
        if (charArray[i].toInt() != baseASCII + i) {
            success = false
            break
        }
        // Do nothing
    }
    println(success)
}