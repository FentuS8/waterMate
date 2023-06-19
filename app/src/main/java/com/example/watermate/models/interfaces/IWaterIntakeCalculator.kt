package com.example.watermate.models.interfaces

// Интерфейс для расчета необходимого объема воды по весу и множителю
interface IWaterIntakeCalculator {
    /**
     * Метод для возвращения объема воды в литрах
     * @param weight вес человека в килограммах
     * @param multiplier множитель в зависимости от степени обезвоживания
     * @return объем воды в литрах в виде дробного числа
     */
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}