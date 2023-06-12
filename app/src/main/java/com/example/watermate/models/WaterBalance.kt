package com.example.watermate.models

class WaterBalance(private val age: Int, private val weight: Double) {
    fun calculateDailyWaterIntake(): Double {
        // Формула для вычисления дневной нормы потребления воды
        val waterIntake = weight * getMultiplierByAge()

        return waterIntake
    }

    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake()
        val glassVolume = 250 // Предположим, что объем одного стакана равен 250 мл
        val waterIntakeInGlasses = (waterIntake / glassVolume).toInt()

        return waterIntakeInGlasses
    }

    private fun getMultiplierByAge(): Double {
        return when {
            age < 14 -> 40.0 // Если возраст меньше 14 лет, множитель равен 40
            age < 30 -> 35.0 // Если возраст меньше 30 лет, множитель равен 35
            age < 55 -> 30.0 // Если возраст меньше 55 лет, множитель равен 30
            else -> 25.0 // В остальных случаях множитель равен 25
        }
    }
}

//val userAge = 25
//val userWeight = 70.5
//
//val waterBalance = WaterBalance(userAge, userWeight)
//
//val dailyWaterIntake = waterBalance.calculateDailyWaterIntake()
//val dailyWaterIntakeInGlasses = waterBalance.calculateDailyWaterIntakeInGlasses()
//
//println("Пользователь должен пить $dailyWaterIntake литров воды в день.")
//println("Это примерно $dailyWaterIntakeInGlasses стаканов воды в день.")

