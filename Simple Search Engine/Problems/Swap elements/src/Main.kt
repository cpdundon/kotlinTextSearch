// The array numbers already exists. Write only exchange actions here.
val firstNum = numbers.first()
numbers[0] = numbers.last()
numbers[numbers.lastIndex] = firstNum