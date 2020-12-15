import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val speed = scanner.nextLine().trim().toInt()
    val limitUser = scanner.nextLine().trim()
    println( when {
            (limitUser.toIntOrNull() is Int) -> lawEnforcement(sysLimit = limitUser.toInt(), speed = speed)
            (limitUser.toLowerCase().trim() == "no limit") -> lawEnforcement(speed=speed)
            else -> ""
    })
}

fun lawEnforcement(speed: Int, sysLimit: Int = 60): String {
    return when {
        (speed > sysLimit) -> "Exceeds the limit by ${speed - sysLimit} kilometers per hour"
        else -> "Within the limit"
    }
}