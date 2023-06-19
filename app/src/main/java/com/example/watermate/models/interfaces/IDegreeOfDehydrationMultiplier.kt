package com.example.watermate.models.interfaces

// Интерфейс для получения множителя в зависимости от степени обезвоживания
interface IDegreeOfDehydrationMultiplier {
    /**
     * Метод для возвращения множителя от 0.05 до 0.10
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return множитель в виде дробного числа
     * @throws IllegalArgumentException если степень обезвоживания не в диапазоне от 1 до 3
     */
    fun getMultiplier(degreeOfDehydration: Int): Double
}