enum class DangerLevel () {
    HIGH,
    MEDIUM,
    LOW;

    fun getLevel() = values().size - ordinal
}