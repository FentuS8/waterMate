package com.example.watermate.models

interface IDegreeOfDehydrationMultiplier {
    fun getMultiplier(): Double
}

interface IWaterIntakeCalculator {
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

interface IWaterIntakeInGlassesCalculator {
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}

class DehydrationTreatment(
    private val degreeOfDehydration: Int,
    private val age: Int,
    private val weight: Double,
    private val degreeOfDehydrationMultiplier: IDegreeOfDehydrationMultiplier,
    private val waterIntakeCalculator: IWaterIntakeCalculator,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesCalculator
) {
    fun calculateWaterIntake(): Double {
        val multiplier = degreeOfDehydrationMultiplier.getMultiplier()
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier)
    }

    fun calculateWaterIntakeInGlasses(): Int {
        val waterIntake = calculateWaterIntake()
        val glassVolume = 250
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume)
    }
}

class DefaultDegreeOfDehydrationMultiplier(private val degreeOfDehydration: Int) : IDegreeOfDehydrationMultiplier {
    override fun getMultiplier(): Double {
        return when (degreeOfDehydration) {
            1 -> 0.05
            2 -> 0.08
            3 -> 0.10
            else -> throw IllegalArgumentException("Недопустимый уровень дегидратации")
        }
    }
}

class DefaultWaterIntakeCalculator : IWaterIntakeCalculator {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier
    }
}

class DefaultWaterIntakeInGlassesCalculator : IWaterIntakeInGlassesCalculator {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt()
    }
}
