package com.example.watermate.models

import com.example.watermate.utils.interfaces.IInjectionsProvider
import com.example.watermate.utils.interfaces.ISolutionProvider


// Абстрактный класс для электролитов
abstract class Electrolytes (
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

