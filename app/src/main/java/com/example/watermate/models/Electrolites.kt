package com.example.watermate.models

interface ISolutionProvider {
    fun getSolution(element: String): String
}

interface IInjectionsProvider {
    fun getInjections(age: Int): String
}

class Electrolites(
    private val element: String,
    private val age: Int,
    private val solutionProvider: ISolutionProvider,
    private val injectionsProvider: IInjectionsProvider
) {

    fun getInfo(): String {
        val solution = solutionProvider.getSolution(element)
        val injections = injectionsProvider.getInjections(age)
        return "We administer a ten percent solution of\n\n$solution,\n\nin $injections injections"
    }
}

class DefaultSolutionProvider : ISolutionProvider {
    override fun getSolution(element: String): String {
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
}

class DefaultInjectionsProvider : IInjectionsProvider {
    override fun getInjections(age: Int): String {
        return when (age) {
            in 1..2 -> "1-2"
            else -> "1-10"
        }
    }
}