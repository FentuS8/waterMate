package com.example.watermate.models

class DehydrationTreatment {
    /**
     * Метод для расчета объема воды по весу и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return объем воды в литрах в виде дробного числа
     */
    fun calculateWaterIntake(weight: Double, degreeOfDehydration: Int): Double {
        val multiplier = getMultiplier(degreeOfDehydration)
        return weight * multiplier
    }

    /**
     * Метод для расчета количества стаканов воды по весу и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return количество стаканов воды в виде целого числа
     */
    fun calculateWaterIntakeInGlasses(weight: Double, degreeOfDehydration: Int): Int {
        val waterIntake = calculateWaterIntake(weight, degreeOfDehydration)
        val glassVolume = 250 // Объем стакана в мл
        return (waterIntake * 1000 / glassVolume).toInt()
    }

    /**
     * Метод для получения множителя в зависимости от степени обезвоживания
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return множитель в виде дробного числа
     * @throws IllegalArgumentException если степень обезвоживания не в диапазоне от 1 до 3
     */
    private fun getMultiplier(degreeOfDehydration: Int): Double {
        return when (degreeOfDehydration) {
            1 -> 0.05
            2 -> 0.08
            3 -> 0.1
            else -> 0.06
        }
    }
}
