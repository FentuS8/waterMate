package com.example.watermate.models

import com.example.watermate.utils.interfaces.IEvaluator

// Класс для вычисления общего количества баллов по всем оценщикам
class DehydrationLevel(private val evaluators: List<IEvaluator>) {
    /**
     * Метод для получения общего количества баллов по всем оценщикам
     * @return сумма баллов всех оценщиков в списке evaluators
     */
    fun getPoints(): Int {
        return evaluators.sumOf { it.evaluate() } // Суммируем оценки всех оценщиков в списке
    }
}