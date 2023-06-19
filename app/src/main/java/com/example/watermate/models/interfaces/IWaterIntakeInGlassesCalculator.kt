package com.example.watermate.models.interfaces

// Интерфейс для расчета необходимого количества стаканов воды по объему воды и объему стакана
interface IWaterIntakeInGlassesCalculator {
    /**
     * Метод для возвращения количества стаканов воды
     * @param waterIntake объем воды в литрах
     * @param glassVolume объем стакана в миллилитрах
     * @return количество стаканов воды в виде целого числа
     */
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}