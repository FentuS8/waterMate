package com.example.watermate.models

import com.example.watermate.utils.interfaces.IAgeMultiplierProvider
import com.example.watermate.utils.interfaces.IWaterIntakeConverter
import com.example.watermate.utils.interfaces.IWaterIntakeInGlassesConverter

// Конкретная реализация класса WaterBalance для пользователя с заданным возрастом
class UserWaterBalance(
    private val age: Int,
    weight: Double,
    ageMultiplierProvider: IAgeMultiplierProvider,
    waterIntakeCalculator: IWaterIntakeConverter,
    waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) : WaterBalance(weight, ageMultiplierProvider, waterIntakeCalculator, waterIntakeInGlassesCalculator) {

    // Переопределение метода для получения возраста пользователя
    override fun getAge(): Int {
        return age // Возвращаем заданный возраст пользователя
    }
}