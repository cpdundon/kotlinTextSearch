import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val inpChars = input.nextLine().split(' ').map {it.trim()}
    val ints = inpChars.toTypedArray()
    val x = mutableMapOf<Int, Boolean>(1 to false, 2 to false, 3 to false, 4 to false, 5 to false)
    val y = mutableMapOf<Int, Boolean>(1 to false, 2 to false, 3 to false, 4 to false, 5 to false)

    println()
    for ( i in 0 until ints.lastIndex step 2) {
        x[ints[i].toInt()] = true
        y[ints[i+1].toInt()] = true
    }

    var outStr = ""
    for (i in 1 .. 5) {
       if (!x.getOrDefault(i, false)) outStr += " $i"
    }
    println(outStr.trim())

    outStr = ""
    for (i in 1 .. 5) {
        if (!y.getOrDefault(i, false)) outStr += " $i"
    }
    println(outStr.trim())
}