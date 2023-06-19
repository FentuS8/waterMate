package com.example.watermate.models

import com.example.watermate.models.interfaces.IInjectionsProvider
import com.example.watermate.models.interfaces.ISolutionProvider


// Абстрактный класс для электролитов
class Electrolites (
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


