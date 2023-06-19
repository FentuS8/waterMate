package com.example.watermate.models

import com.example.watermate.models.interfaces.IAgeMultiplierProvider
import com.example.watermate.models.interfaces.IWaterIntakeConverter
import com.example.watermate.models.interfaces.IWaterIntakeInGlassesConverter


// Класс для расчета водного баланса
class WaterBalance(
    private val weight: Double,
    private val age: Int,
    private val ageMultiplierProvider: IAgeMultiplierProvider,
    private val waterIntakeCalculator: IWaterIntakeConverter,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) {
    // Метод для расчета суточного потребления воды
    fun calculateDailyWaterIntake(): Double {
        val multiplier = ageMultiplierProvider.getMultiplierByAge(age) // Получаем множитель по возрасту пользователя
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier) // Возвращаем потребление воды по весу и множителю
    }

    // Метод для расчета суточного потребления воды в стаканах
    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake() // Получаем потребление воды по весу и возрасту пользователя
        val glassVolume = 250 // Задаем объем стакана в миллилитрах
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume) // Возвращаем потребление воды в стаканах по объему воды и объему стакана
    }
}
