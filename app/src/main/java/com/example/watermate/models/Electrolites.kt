package com.example.watermate.models

// Интерфейс для поставщика раствора
interface ISolutionProvider {
    /**
     * Метод для возвращения раствора по элементу
     * @param element - название элемента
     * @return строка с раствором
     */
    fun getSolution(element: String): String
}

// Интерфейс для поставщика инъекций
interface IInjectionsProvider {
    /**
     * Метод для возвращения количества инъекций по возрасту
     * @param age - возраст в годах
     * @return строка с количеством инъекций
     */
    fun getInjections(age: Int): String
}

// Абстрактный класс для электролитов
abstract class Electrolites(
    private val element: String,
    private val age: Int,
    private val solutionProvider: ISolutionProvider,
    private val injectionsProvider: IInjectionsProvider
) {

    /**
     * Метод для получения информации об электролитах
     * @return строка с информацией об электролитах
     */
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
    /**
     * Метод для возвращения раствора кальция
     * @param element - название элемента (должно быть "Calcium")
     * @return строка с раствором кальция
     */
    override fun getSolution(element: String): String {
        return "0.5 ml/day (calcium chloride) - 1.0 ml/day (calcium gluconate)" // Возвращаем раствор кальция в виде строки
    }
}

// Конкретный класс для поставщика инъекций по возрасту
class AgeBasedInjectionsProvider : IInjectionsProvider {
    /**
     * Метод для возвращения количества инъекций по возрасту
     * @param age - возраст в годах
     * @return строка с количеством инъекций в зависимости от возраста
     */
    override fun getInjections(age: Int): String {
        return when (age) { // Возвращаем количество инъекций в зависимости от значения age
            in 1..2 -> "1-2" // Для возраста от 1 до 2 лет - 1-2 инъекции
            else -> "1-10" // Для всех остальных случаев - 1-10 инъекций
        }
    }
}
