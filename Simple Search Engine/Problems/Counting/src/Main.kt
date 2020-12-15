import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val nN = scanner.nextInt()
    val nSet = IntArray(nN)

    for (i in 0 .. nSet.lastIndex) {
        nSet[i] = scanner.nextInt()
    }

    val mM = scanner.nextInt()
    var cnt = 0
    for (itm in nSet) {
        if (mM == itm) cnt++
    }

    println(cnt)
}