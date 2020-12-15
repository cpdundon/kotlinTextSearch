fun main() {
    val uidIn = readLine()!!
    greeting(uidIn)
}

fun greeting(uid: String = "HIDDEN") {
    if (uid == "HIDDEN") {
        println("Hello, secret user!")
    } else {
        println("Hello, $uid!")
    }
}