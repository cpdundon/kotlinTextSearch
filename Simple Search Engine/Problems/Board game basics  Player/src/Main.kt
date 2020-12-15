class Player(val id: Int, val name: String, val hp: Int = 100) {
    companion object {
        private var lastId = 0

        fun create(name: String): Player {
            return Player(++lastId, name)
        }
    }
}