package com.example.watermate.models

// Интерфейс для поставщика раствора
interface ISolutionProvider {
    fun getSolution(element: String): String
}

// Интерфейс для поставщика инъекций
interface IInjectionsProvider {
    fun getInjections(age: Int): String
}

// Абстрактный класс для электролитов
abstract class Electrolites(
    private val element: String,
    private val age: Int,
    private val solutionProvider: ISolutionProvider,
    private val injectionsProvider: IInjectionsProvider
) {

    // Метод для получения информации об электролитах
    fun getInfo(): String {
        val solution = solutionProvider.getSolution(element)
        val injections = injectionsProvider.getInjections(age)
        return "We administer a ten percent solution of\n\n$solution,\n\nin $injections injections"
    }
}

// Конкретный класс для кальция
class Calcium(
    age: Int,
    solutionProvider: ISolutionProvider,
    injectionsProvider: IInjectionsProvider
) : Electrolites("Calcium", age, solutionProvider, injectionsProvider)

// Конкретный класс для поставщика раствора кальция
class CalciumSolutionProvider : ISolutionProvider {
    override fun getSolution(element: String): String {
        return "0.5 ml/day (calcium chloride) - 1.0 ml/day (calcium gluconate)"
    }
}

// Конкретный класс для поставщика инъекций по возрасту
class AgeBasedInjectionsProvider : IInjectionsProvider {
    override fun getInjections(age: Int): String {
        return when (age) {
            in 1..2 -> "1-2"
            else -> "1-10"
        }
    }
}
