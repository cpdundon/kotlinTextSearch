fun generate(functionName: String): (Int) -> Int {
    fun id (i: Int): Int { return i }
    fun half (i: Int): Int { return i / 2 }
    fun zero (i: Int): Int { return 0 }
    return when (functionName) {
        "identity" -> ::id
        "half" -> ::half
        else -> ::zero
    }
}