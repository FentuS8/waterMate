package com.example.watermate.utils.evaluators

import com.example.watermate.utils.interfaces.IEvaluator

// Класс для оценки по наличию слез при плаче
class DefaultTearsEvaluator(private val tears: String) : IEvaluator {
    /**
     * Метод для оценки по наличию слез при плаче
     * @return оценка в зависимости от значения tears: 0 - есть, 1 - мало, 2 - нет, иначе - 0
     */
    override fun evaluate(): Int {
        return when (tears) { // Возвращаем оценку в зависимости от значения tears
            "Yes" -> 0 // Есть слезы при плаче - 0 баллов
            "Few" -> 1 // Мало слез при плаче - 1 балл
            "No" -> 2 // Нет слез при плаче - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}