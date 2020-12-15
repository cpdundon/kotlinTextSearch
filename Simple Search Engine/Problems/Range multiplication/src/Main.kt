val lambda: (Long, Long) -> Long = {lft, rt ->
    var rtn = 1L
    for (i in lft..rt) {
        rtn *= i
    }
    rtn
}

