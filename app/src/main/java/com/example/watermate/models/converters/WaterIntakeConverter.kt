package com.example.watermate.models.converters

import com.example.watermate.models.interfaces.IWaterIntakeConverter

// Класс для расчета объема воды по весу и множителю
class WaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier // Возвращаем произведение веса и множителя
    }
}