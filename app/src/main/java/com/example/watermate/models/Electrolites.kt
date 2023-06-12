package com.example.watermate.models

// Интерфейс для поставщика раствора
interface ISolutionProvider {
    fun getSolution(element: String): String // Метод для возвращения раствора по элементу
}

// Интерфейс для поставщика инъекций
interface IInjectionsProvider {
    fun getInjections(age: Int): String // Метод для возвращения количества инъекций по возрасту
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
        val solution = solutionProvider.getSolution(element) // Получаем раствор по элементу
        val injections = injectionsProvider.getInjections(age) // Получаем количество инъекций по возрасту
        return "We administer a ten percent solution of\n\n$solution,\n\nin $injections injections" // Возвращаем информацию в виде строки
    }
}

// Конкретный класс для кальция
class Calcium(
    age: Int,
    solutionProvider: ISolutionProvider,
    injectionsProvider: IInjectionsProvider
) : Electrolites("Calcium", age, solutionProvider, injectionsProvider) // Наследуемся от абстрактного класса электролитов и передаем параметры

// Конкретный класс для поставщика раствора кальция
class CalciumSolutionProvider : ISolutionProvider {
    override fun getSolution(element: String): String {
        return "0.5 ml/day (calcium chloride) - 1.0 ml/day (calcium gluconate)" // Возвращаем раствор кальция в виде строки
    }
}

// Конкретный класс для поставщика инъекций по возрасту
class AgeBasedInjectionsProvider : IInjectionsProvider {
    override fun getInjections(age: Int): String {
        return when (age) { // Возвращаем количество инъекций в зависимости от значения age
            in 1..2 -> "1-2" // Для возраста от 1 до 2 лет - 1-2 инъекции
            else -> "1-10" // Для всех остальных случаев - 1-10 инъекций
        }
    }
}
