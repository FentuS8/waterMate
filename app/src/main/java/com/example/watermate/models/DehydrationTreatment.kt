package com.example.watermate.models

import com.example.watermate.utils.interfaces.IDegreeOfDehydrationMultiplier


// Класс для лечения обезвоживания с помощью разных калькуляторов
class DehydrationTreatment(
    private val degreeOfDehydrationMultiplier: IDegreeOfDehydrationMultiplier,
    private val waterIntakeCalculator: IWaterIntakeConverter,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) {
    /**
     * Метод для расчета объема воды по весу и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return объем воды в литрах в виде дробного числа
     */
    fun calculateWaterIntake(weight: Double, degreeOfDehydration: Int): Double {
        val multiplier = degreeOfDehydrationMultiplier.getMultiplier(degreeOfDehydration) // Получаем множитель по степени обезвоживания
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier) // Возвращаем объем воды по весу и множителю
    }

    /**
     * Метод для расчета количества стаканов воды по весу и степени обезвоживания
     * @param weight вес человека в килограммах
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return количество стаканов воды в виде целого числа
     */
    fun calculateWaterIntakeInGlasses(weight: Double, degreeOfDehydration: Int): Int {
        val waterIntake = calculateWaterIntake(weight, degreeOfDehydration) // Получаем объем воды по весу и степени обезвоживания
        val glassVolume = 250 // Задаем объем стакана в миллилитрах
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume) // Возвращаем количество стаканов воды по объему воды и объему стакана
    }
}
