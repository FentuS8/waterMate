package com.example.watermate.models.evaluators

import com.example.watermate.models.interfaces.IEvaluator

// Класс для оценки по внешнему виду
class DefaultAppearanceEvaluator(private val appearance: String) : IEvaluator {
    /**
     * Метод для оценки по внешнему виду
     * @return оценка в зависимости от значения appearance: 0 - нормальный, 1 - раздражительный, 2 - вялый, иначе - 0
     */
    override fun evaluate(): Int {
        return when (appearance) { // Возвращаем оценку в зависимости от значения appearance
            "Normal" -> 0 // Нормальный внешний вид - 0 баллов
            "Irritable" -> 1 // Раздражительный внешний вид - 1 балл
            "Sluggish" -> 2 // Вялый внешний вид - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}