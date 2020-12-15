import java.util.*

fun main() {
    // put your code here
    val scanner = Scanner(System.`in`)
    val word = scanner.nextLine().trim(' ').toLowerCase().toCharArray()

    val map = emptyMap<Char, Int>().toMutableMap()
    word.forEach{
        map[it] = map.getOrDefault(it, 0) + 1
    }
    val numberOfDups = map.count(){it.value == 1}
    println(numberOfDups)
}