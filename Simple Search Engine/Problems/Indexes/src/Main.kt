fun solution(products: List<String>, product: String) {
    var slots = ""
    for (i in products.indices) {
        if (products[i] == product) { slots += "$i " }
    }

    println(slots.trim())
}