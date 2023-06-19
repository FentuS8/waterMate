package com.example.watermate.models.evaluators

import com.example.watermate.models.interfaces.IEvaluator

// Класс для оценки по состоянию слизистой оболочки рта
class DefaultMucousEvaluator(private val mucous: String) : IEvaluator {
    /**
     * Метод для оценки по состоянию слизистой оболочки рта
     * @return оценка в зависимости от значения mucous: 0 - влажная, 1 - липкая, 2 - сухая, иначе - 0
     */
    override fun evaluate(): Int {
        return when (mucous) { // Возвращаем оценку в зависимости от значения mucous
            "Wet" -> 0 // Влажная слизистая оболочка - 0 баллов
            "Sticky" -> 1 // Липкая слизистая оболочка - 1 балл
            "Dry" -> 2 // Сухая слизистая оболочка - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}