package com.example.watermate.utils.converters

import com.example.watermate.utils.interfaces.IWaterIntakeConverter

// Класс для расчета объема воды по весу и множителю
class WaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier // Возвращаем произведение веса и множителя
    }
}