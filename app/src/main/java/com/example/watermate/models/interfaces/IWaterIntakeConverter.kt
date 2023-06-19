package com.example.watermate.models.interfaces

// Интерфейс для расчета потребления воды в зависимости от веса и множителя
interface IWaterIntakeConverter {
    /**
     * Метод для возвращения потребления воды в литрах по весу и множителю
     * @param weight вес пользователя в килограммах
     * @param multiplier множитель для расчета потребления воды
     * @return потребление воды в литрах
     */
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}