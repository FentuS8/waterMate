package com.example.watermate.models

class DehydrationTreatment {
    /**
     * Метод для расчета объема воды по весу, возрасту и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param age возраст человека
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return объем воды в литрах в виде дробного числа
     */
    fun calculateWaterIntake(weight: Double, age: Int, degreeOfDehydration: Int): Double {
        val multiplier = getMultiplier(degreeOfDehydration, age)
        return weight * multiplier
    }

    /**
     * Метод для расчета количества стаканов воды по весу, возрасту и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param age возраст человека
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return количество стаканов воды в виде целого числа
     */
    fun calculateWaterIntakeInGlasses(weight: Double, age: Int, degreeOfDehydration: Int): Int {
        val waterIntake = calculateWaterIntake(weight, age, degreeOfDehydration)
        val glassVolume = 250 // Объем стакана в мл
        return (waterIntake * 1000 / glassVolume).toInt()
    }

    /**
     * Метод для получения множителя в зависимости от степени обезвоживания и возраста
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @param age возраст человека
     * @return множитель в виде дробного числа
     * @throws IllegalArgumentException если степень обезвоживания не в диапазоне от 1 до 3
     */
    private fun getMultiplier(degreeOfDehydration: Int, age: Int): Double {
        val baseMultiplier = when (degreeOfDehydration) {
            1 -> 0.05
            2 -> 0.08
            3 -> 0.1
            else -> 0.06
        }

        // Учет возраста
        val ageMultiplier = when {
            age < 14 -> 1.2
            age < 30 -> 1.0
            age < 55 -> 0.8
            else -> 0.6
        }

        return baseMultiplier * ageMultiplier
    }
}

