package com.example.watermate.utils.interfaces

// Интерфейс для оценки уровня обезвоживания по разным параметрам
interface IEvaluator {
    /**
     * Метод для возвращения оценки от 0 до 2
     * @return оценка обезвоживания в виде целого числа от 0 до 2
     */
    fun evaluate(): Int
}