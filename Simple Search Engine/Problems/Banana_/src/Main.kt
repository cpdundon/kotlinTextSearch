fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    strings.forEachIndexed { index, s -> if (s == str) strings[index] = "Banana" }
    return strings
}