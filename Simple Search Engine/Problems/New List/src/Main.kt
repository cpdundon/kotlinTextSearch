fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    val mutNumbers = numbers.toMutableList()
    mutNumbers.add(number)
    return mutNumbers
}