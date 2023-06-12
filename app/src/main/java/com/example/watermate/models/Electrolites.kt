package com.example.watermate.models

class Electrolites(private val element: String, private val age: Int) {

    fun getInfo(): String {
        val solution = getSolution()
        val injections = getInjections()
        return "We administer a ten percent solution of\n\n$solution,\n\nin $injections injections"
    }

    private fun getSolution(): String {
        val calciumChloride = when (element) {
            "Calcium" -> "0.5 ml/day (calcium chloride)"
            else -> ""
        }
        val calciumGluconate = when (element) {
            "Calcium" -> "1.0 ml/day (calcium gluconate)"
            else -> ""
        }
        return "$calciumChloride - $calciumGluconate"
    }

    private fun getInjections(): String {
        val injections = when (age) {
            in 1..2 -> "1-2"
            else -> "1-10"
        }
        return injections
    }
}

//fun main() {
//    val electrolites = Electrolites("Calcium", 1)
//    println(electrolites.getInfo())
//}
