import kotlin.math.hypot

fun perimeter(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x4: Double = x3, y4: Double = y3): Double {
    val len12 = hypot((x1 - x2), (y1 - y2))
    val len23 = hypot((x2 - x3), (y2 - y3))
    val len34 = hypot((x3 - x4), (y3 - y4))
    val len41 = hypot((x4 - x1), (y4 - y1))
    return len12 + len23 + len34 + len41
}