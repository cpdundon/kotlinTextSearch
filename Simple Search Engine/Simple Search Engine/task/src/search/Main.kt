package search
import java.util.*
import java.io.File

fun main(args: Array<String>) {
        // write your code here

        val scanner = Scanner(System.`in`)
        val shipsIn = getShipData(args[1])
        val shipMap = buildIndexMap(shipsIn)

        while (true) {
                println()
                println("=== Menu ===")
                println("1. Find a ship")
                println("2. Print all ships")
                println("0. Exit")
                when (scanner.nextInt()) {
                        0 -> break
                        1 -> conductQueries(shipMap, shipsIn)
                        2 -> printShips(shipsIn)
                        else -> println("\nIncorrect option! Try again.")
                }
        }
        println("\nBye!")
}

fun buildIndexMap(shipList: Array<Array<String>>): MutableMap<String, MutableSet<Int>> {
        val rtn = mutableMapOf<String, MutableSet<Int>>()

        for (idx in shipList.indices) {
                shipList[idx].forEach {
                        val word = it.toLowerCase()
                        if (rtn[word].isNullOrEmpty()) {
                                rtn[word] = mutableSetOf(idx)
                        } else {
                                rtn[word]?.plusAssign(idx)
                        }
                }
        }
        return rtn
}

fun printShips(shipsIn: Array<Array<String>>) {
        println()
        shipsIn.forEach { ship ->
                var outStr = ""
                ship.forEach {
                    outStr += "$it "
                }
                println(outStr.trim())
        }
}

fun getShipData(lineCnt: Int): Array<Array<String>> {
        val scanner = Scanner(System.`in`)
        var rtn: Array<Array<String>> = emptyArray()

        repeat(lineCnt) {
                val inpShipDetails = scanner.nextLine()
                var shipDetails = inpShipDetails.split(",").toTypedArray()
                shipDetails = trimShipDetails(shipDetails)
                rtn += shipDetails
        }
        return rtn
}

fun getShipData(fileName: String): Array<Array<String>> {

        var rtn: Array<Array<String>> = emptyArray()

        File(fileName).forEachLine {
                var shipDetails = it.split(" ").toTypedArray()
                shipDetails = trimShipDetails(shipDetails)
                rtn += shipDetails
        }
        return rtn
}

fun trimShipDetails(strInpArray: Array<String>): Array<String> {
        var rtn: Array<String> = emptyArray()
        strInpArray.forEach {
                rtn += it.trim(' ')
        }
        return rtn
}

fun searchForWordInSet (shipsIn: Array<Array<String>>, word: String): Array<Array<String>> {
        var rtn: Array<Array<String>> = emptyArray()
        for (i in shipsIn.indices) {
                if (findWordInLine(shipsIn[i], word)) rtn += shipsIn[i]
        }

        return rtn
}

fun findWordInLine(ship: Array<String>, word: String): Boolean {
        return (ship.toList().filter { it.contains(word, true) }).isNotEmpty()
}

fun conductQueries(shipsIn: Array<Array<String>>) {
        val scanner = Scanner(System.`in`)
        println("\nEnter ship data to search:")

        val searchKey = scanner.nextLine().trim(' ')
        val goodLines = searchForWordInSet(shipsIn, searchKey)
        if (goodLines.isEmpty()) {
                println("No matching ships found.")
                return
        }

        println(message = "Found ships:")
        goodLines.forEach { line ->
                print(line[0])
                for (i in 1 until line.size) {
                        print(" " + line[i])
                }
                println()
        }
}

fun conductQueries(dataMap: MutableMap<String, MutableSet<Int>>, shipsIn: Array<Array<String>> ) {
        val scanner = Scanner(System.`in`)
        println("\nSelect a matching strategy: ALL, ANY, NONE")
        val searchStrat = scanner.nextLine().trim(' ')
        val strat = SearchStrategy.getEnum(searchStrat)

        println("Enter ship data to search:")

        val searchKeys = scanner.nextLine().trim(' ').toLowerCase().split(' ').toTypedArray()

        val searchRtn = strat.findInformation(dataMap, searchKeys)

        if (searchRtn.isNullOrEmpty()) {
                println("No matching ships found.")
                return
        }

        println(message = "Found ships:")
        searchRtn.forEach { lineIdx ->
                var line = ""
                for (wordIdx in shipsIn[lineIdx].indices) {
                        line += (shipsIn[lineIdx][wordIdx] + " ")
                }
                println(line.trim())
        }
}

enum class SearchStrategy () {
        ANY,
        ALL,
        NONE,
        NULL;

        companion object {
                fun getEnum(strat: String): SearchStrategy {
                        for (enum in SearchStrategy.values()) {
                                if (strat.toUpperCase() == enum.name) return enum
                        }
                        return NULL
                }
        }

        fun findInformation (dataMap: MutableMap<String
                , MutableSet<Int>>, searchKeys: Array<String>) : Set<Int> {

                var runningMax = -1
                dataMap.values.forEach(){ if (runningMax < (it.maxOrNull()!!) ) {runningMax = it.maxOrNull()!!
                }}

                var rtn = when (this.name) {
                        "ANY" -> mutableSetOf<Int>()
                        else -> {
                                val temp = mutableSetOf<Int>()
                                for (i in 0 .. runningMax) { temp.add(i) }
                                temp
                        }
                }
                searchKeys.forEach { key ->
                        when (this.name) {
                                "ANY" -> { if (dataMap.containsKey(key)) {
                                                dataMap[key]?.forEach { rtn.add(it) }
                                                }
                                        }       
                                "ALL" -> {
                                                rtn = if (dataMap.containsKey(key)) {
                                                        (( rtn as Set<Int> intersect dataMap[key] as Set<Int>)
                                                                as MutableSet<Int>)
                                                } else {
                                                        mutableSetOf<Int>()
                                                }
                                        }
                                "NONE" -> {
                                                rtn = if (dataMap.contains(key)) {
                                                                (rtn as Set<Int> subtract dataMap[key]
                                                                        as Set<Int>) as MutableSet<Int>
                                                        } else {
                                                                rtn
                                                        }
                                        }
                                else -> return rtn // NULL search strategy.
                                }
                        }
                return rtn
        }
}