package com.example.watermate.utils.interfaces

// Интерфейс для расчета потребления воды в стаканах в зависимости от объема стакана
interface IWaterIntakeInGlassesConverter {
    /**
     * Метод для возвращения потребления воды в стаканах по объему воды и объему стакана
     * @param waterIntake потребление воды в литрах
     * @param glassVolume объем стакана в миллилитрах
     * @return потребление воды в стаканах
     */
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}