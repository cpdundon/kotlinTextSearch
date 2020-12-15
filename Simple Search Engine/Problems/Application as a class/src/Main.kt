class Application(val name: String) {

    // write the run method here
    fun run (vararg strArgs: String) {
        println(name)
        strArgs.forEach { println(it) }
    }
}