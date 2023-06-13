package com.example.watermate.models

import com.example.watermate.utils.interfaces.IAgeMultiplierProvider
import com.example.watermate.utils.interfaces.IWaterIntakeConverter
import com.example.watermate.utils.interfaces.IWaterIntakeInGlassesConverter


// Абстрактный класс для расчета водного баланса
abstract class WaterBalance(
    private val weight: Double,
    private val ageMultiplierProvider: IAgeMultiplierProvider,
    private val waterIntakeCalculator: IWaterIntakeConverter,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) {
    // Абстрактный метод для получения возраста пользователя
    abstract fun getAge(): Int

    // Метод для расчета суточного потребления воды
    fun calculateDailyWaterIntake(): Double {
        val multiplier = ageMultiplierProvider.getMultiplierByAge(getAge()) // Получаем множитель по возрасту пользователя
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier) // Возвращаем потребление воды по весу и множителю
    }

    // Метод для расчета суточного потребления воды в стаканах
    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake() // Получаем потребление воды по весу и возрасту пользователя
        val glassVolume = 250 // Задаем объем стакана в миллилитрах
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume) // Возвращаем потребление воды в стаканах по объему воды и объему стакана
    }
}