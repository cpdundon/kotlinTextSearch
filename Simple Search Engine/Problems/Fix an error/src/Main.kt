class Player(val id: Int, val name: String) {
    companion object {
        var role = "playable character"
        fun getInfo(player: Player): String {
            return "${player.id}, ${player.name}, $role"
        }
    }
}

fun getPlayerInfo(player: Player) = Player.getInfo(player)

//fun main () {
//    val pl = Player(22, "Chris")
//    Player.role = "Awesome Sauce"
//    //pl.role = "dddd"
//    getPlayerInfo(pl)
//}