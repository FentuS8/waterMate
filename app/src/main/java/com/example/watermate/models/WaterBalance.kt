package com.example.watermate.models


class WaterBalance(private val weight: Double, private val age: Int) {
    fun calculateDailyWaterIntake(): Double {
        val multiplier = when {
            age < 14 -> 40.0
            age < 30 -> 35.0
            age < 55 -> 30.0
            else -> 25.0
        }
        return weight * multiplier
    }

    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake()
        val glassVolume = 250
        return (waterIntake / glassVolume).toInt()
    }
}