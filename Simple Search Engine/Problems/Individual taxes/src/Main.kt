import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val nN = scanner.nextInt()

    val arrIncome = getSet(nN, scanner)
    val arrPctTax = getSet(nN, scanner)

    var maxTax = 0
    var maxIdx = 0
    for (i in (nN-1) downTo 0) {
        val taxOfI = arrIncome[i] * arrPctTax[i]
        if (taxOfI > maxTax) {
            maxTax = taxOfI
            maxIdx = i
        }
    }
    println(maxIdx+1)
}

fun getSet(size: Int, scanner: Scanner): IntArray {
    val nSet = IntArray(size)

    for (i in 0 .. nSet.lastIndex) {
        nSet[i] = scanner.nextInt()
    }
    return nSet
}