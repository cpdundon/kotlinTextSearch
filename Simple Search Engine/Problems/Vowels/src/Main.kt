fun main() {
    val letter = readLine()!!
    val vowels = mutableMapOf("a" to 1, "e" to 5, "i" to 9, "o" to 15, "u" to 21)
    val position = when {
        vowels.containsKey(letter.toLowerCase()) -> vowels[letter.toLowerCase()]
        else -> 0
    }

    println(position)
}