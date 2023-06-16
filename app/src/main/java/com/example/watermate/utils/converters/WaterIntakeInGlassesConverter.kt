package com.example.watermate.utils.converters

import com.example.watermate.utils.interfaces.IWaterIntakeInGlassesConverter

// Класс для расчета количества стаканов воды по объему воды и объему стакана
class WaterIntakeInGlassesConverter : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt() // Возвращаем целую часть от деления объема воды на объем стакана
    }
}