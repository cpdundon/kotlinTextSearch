fun main(args: Array<String>) {
    when {
        args.size != 3 -> println("Invalid number of program arguments")
        else -> args.forEachIndexed { index, s ->
            println("Argument %d: %s. It has %d characters".format(index + 1, s, s.length))
        }
    }
}