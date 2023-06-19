package com.example.watermate.models.converters

import com.example.watermate.models.interfaces.IWaterIntakeConverter

// Конкретная реализация интерфейса IWaterIntakeCalculator по умолчанию
class DefaultWaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier // Возвращаем произведение веса и множителя
    }
}