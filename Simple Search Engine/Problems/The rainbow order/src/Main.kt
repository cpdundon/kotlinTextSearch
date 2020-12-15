import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val inStr = input.nextLine().trim()
    val enum = Rainbow.getEnum(inStr)
    println(enum.ordinal + 1)
}

enum class Rainbow () {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET,
    NULL;

    companion object {
        fun getEnum(color: String): Rainbow {
            for (enum in Rainbow.values()) {
                if (color.toUpperCase() == enum.name) return enum
            }
            return NULL
        }
    }
}