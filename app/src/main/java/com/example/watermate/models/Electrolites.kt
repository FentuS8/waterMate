package com.example.watermate.models

class Electrolites(private val element: String, private val age: Int) {
    /**
     * Метод для получения информации об электролитах
     * @return строка с информацией об электролитах
     */
    fun getInfo(): String {
        val solution = getSolution(element) // Получаем раствор по элементу
        val injections = getInjections(age) // Получаем количество инъекций по возрасту
        return "Use a ten percent $solution in $injections ml.\nNo more than 10 ml per day" // Возвращаем информацию в виде строки
    }

    /**
     * Метод для возвращения раствора по элементу
     * @param element - название элемента
     * @return строка с раствором
     */
    private fun getSolution(element: String): String {
        // Возвращаем раствор, соответствующий переданному элементу
        return "solution for $element"
    }

    /**
     * Метод для возвращения количества инъекций по возрасту
     * @param age - возраст в годах
     * @return строка с количеством инъекций
     */
    private fun getInjections(age: Int): String {
        val doses = age / 2
        return "$doses"
    }
}