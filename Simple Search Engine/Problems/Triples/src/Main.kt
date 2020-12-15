import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val nN = scanner.nextInt()
    val nSet = IntArray(nN)

    for (i in 0 .. nSet.lastIndex) {
        nSet[i] = scanner.nextInt()
    }

    var tripleCnt = 0
    for (i in 2..nSet.lastIndex) {
        val triple = 3 * nSet[i] - 3
        val sum = nSet[i] + nSet[i-1] + nSet[i-2]
        if (triple == sum) tripleCnt++
    }
    println(tripleCnt)
}