import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    //println("Please enter the language you are learning...")
    //println("1. Java\n2. Kotlin\n3. Scala\n4. Python")
    when (scanner.nextInt()) {
        1, 3, 4 -> println("No!")
        2 -> println("Yes!")
        else -> println("Unknown number")
    }
}