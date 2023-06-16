package com.example.watermate.utils.evaluators

import com.example.watermate.utils.interfaces.IEvaluator

// Класс для оценки по состоянию глаз
class DefaultEyesEvaluator(private val eyes: String) : IEvaluator {
    /**
     * Метод для оценки по состоянию глаз
     * @return оценка в зависимости от значения eyes: 0 - нормальное, 1 - легкая сонливость, 2 - сонливость, иначе - 0
     */
    override fun evaluate(): Int {
        return when (eyes) { // Возвращаем оценку в зависимости от значения eyes
            "Normal" -> 0 // Нормальное состояние глаз - 0 баллов
            "Light sleepiness" -> 1 // Легкая сонливость - 1 балл
            "Drowsy" -> 2 // Сонливость - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}