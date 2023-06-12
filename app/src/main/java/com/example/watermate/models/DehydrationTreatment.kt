package com.example.watermate.models

interface IDegreeOfDehydrationMultiplier {
    fun getMultiplier(degreeOfDehydration: Int): Double
}

interface IWaterIntakeCalculator {
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

interface IWaterIntakeInGlassesCalculator {
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}

class DegreeOfDehydrationMultiplier : IDegreeOfDehydrationMultiplier {
    override fun getMultiplier(degreeOfDehydration: Int): Double {
        return when (degreeOfDehydration) {
            1 -> 0.05
            2 -> 0.08
            3 -> 0.10
            else -> throw IllegalArgumentException("Недопустимый уровень дегидратации")
        }
    }
}

class WaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier
    }
}

class WaterIntakeInGlassesConvertor : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt()
    }
}

class DehydrationTreatment(
    private val degreeOfDehydrationMultiplier: IDegreeOfDehydrationMultiplier,
    private val waterIntakeCalculator: IWaterIntakeConverter,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) {
    fun calculateWaterIntake(weight: Double, degreeOfDehydration: Int): Double {
        val multiplier = degreeOfDehydrationMultiplier.getMultiplier(degreeOfDehydration)
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier)
    }

    fun calculateWaterIntakeInGlasses(weight: Double, degreeOfDehydration: Int): Int {
        val waterIntake = calculateWaterIntake(weight, degreeOfDehydration)
        val glassVolume = 250
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume)
    }
}

