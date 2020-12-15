// write the BankAccount class here
class BankAccountOld (_deposited: Long, _withdrawn: Long) {
    val deposited = _deposited
    val withdrawn = _withdrawn
    val balance = deposited - withdrawn
}

data class BankAccount (val deposited: Long, val withdrawn: Long) {
    val balance = deposited - withdrawn
}