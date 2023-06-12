package com.example.watermate.models

interface IAgeMultiplierProvider {
    fun getMultiplierByAge(age: Int): Double
}

interface IWaterIntakeConvertor {
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

interface IWaterIntakeInGlassesConvertor {
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}

class WaterBalance(
    private val age: Int,
    private val weight: Double,
    private val ageMultiplierProvider: IAgeMultiplierProvider,
    private val waterIntakeCalculator: IWaterIntakeConvertor,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConvertor
) {
    fun calculateDailyWaterIntake(): Double {
        val multiplier = ageMultiplierProvider.getMultiplierByAge(age)
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier)
    }

    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake()
        val glassVolume = 250
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume)
    }
}

class DefaultAgeMultiplierProvider : IAgeMultiplierProvider {
    override fun getMultiplierByAge(age: Int): Double {
        return when {
            age < 14 -> 40.0
            age < 30 -> 35.0
            age < 55 -> 30.0
            else -> 25.0
        }
    }
}

class DefaultWaterIntakeConvertor : IWaterIntakeCalculator {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier
    }
}

class DefaultWaterIntakeInGlassesConvertor : IWaterIntakeInGlassesCalculator {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt()
    }
}