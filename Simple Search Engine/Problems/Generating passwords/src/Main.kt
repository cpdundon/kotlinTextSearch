import java.util.*

fun main() {
    // write your code here    
    val scanner = Scanner(System.`in`)

    val inpLine = scanner.nextLine()
    val strInpArray = inpLine.split(" ").toTypedArray()

    val inpInts = strInpArray.map { it.toInt() }.toTypedArray()

    var outStr = ""
    val lenABC = (inpInts[0] + inpInts[1] + inpInts[2])
    val nextCap = 'A' + (inpInts[0] % 26) + 1
    outStr += letterRun('A', 26, inpInts[0])
    outStr += letterRun('a', 26, inpInts[1])
    outStr += letterRun('0', 10, inpInts[2])
    outStr += letterRun(nextCap, 26, (inpInts[3]
            - (lenABC)))

    println(outStr)
}

fun letterRun(startChar: Char, runLen: Int, stripLen: Int): String {
    var rtnString = ""
    for (i in 0 until stripLen) {
        rtnString += (startChar + i % runLen)
    }
    return rtnString
}