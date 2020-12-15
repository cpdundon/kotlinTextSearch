import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val cIn = input.next().trim(' ').toLowerCase()
    var rtn: String = ""
    repeat(26) {
        val nextChar = 'a' + it
        if (nextChar.toString() == cIn) {
            println (rtn)
            return
        }
        rtn += nextChar
    }
}