package com.example.watermate.models

class DehydrationTreatment(private val degreeOfDehydration: Int, private val age: Int, private val weight: Double) {
    fun calculateWaterIntake(): Double {
        val multiplier = getMultiplierByDegreeOfDehydration()
        val waterIntake = weight * multiplier

        return waterIntake
    }

    fun calculateWaterIntakeInGlasses(): Int {
        val waterIntake = calculateWaterIntake()
        val glassVolume = 250 // Предположим, что объем одного стакана равен 250 мл
        val waterIntakeInGlasses = (waterIntake / glassVolume).toInt()

        return waterIntakeInGlasses
    }

    private fun getMultiplierByDegreeOfDehydration(): Double {
        return when (degreeOfDehydration) {
            1 -> 0.05 // 5% дегидратации, множитель 0.05
            2 -> 0.08 // 6-9% дегидратации, множитель 0.08
            3 -> 0.10 // 10% дегидратации, множитель 0.10
            else -> throw IllegalArgumentException("Недопустимый уровень дегидратации")
        }
    }
}

//val degreeOfDehydration = 2 // Уровень дегидратации: 2 (6-9%)
//val userAge = 25
//val userWeight = 70.5
//
//val dehydrationTreatment = DehydrationTreatment(degreeOfDehydration, userAge, userWeight)
//
//val waterIntake = dehydrationTreatment.calculateWaterIntake()
//val waterIntakeInGlasses = dehydrationTreatment.calculateWaterIntakeInGlasses()
//
//println("Пользователь должен пить $waterIntake мл воды в день.")
//println("Это примерно $waterIntakeInGlasses стаканов воды в день.")

//123