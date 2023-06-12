package com.example.watermate.models

// Интерфейс для предоставления множителя в зависимости от возраста
interface IAgeMultiplierProvider {
    fun getMultiplierByAge(age: Int): Double
}

// Интерфейс для расчета потребления воды в зависимости от веса и множителя
interface IWaterIntakeConverter {
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

// Интерфейс для расчета потребления воды в стаканах в зависимости от объема стакана
interface IWaterIntakeInGlassesConverter {
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int
}

// Абстрактный класс для расчета водного баланса
abstract class WaterBalance(
    private val weight: Double,
    private val ageMultiplierProvider: IAgeMultiplierProvider,
    private val waterIntakeCalculator: IWaterIntakeConverter,
    private val waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) {
    // Абстрактный метод для получения возраста пользователя
    abstract fun getAge(): Int

    // Метод для расчета суточного потребления воды
    fun calculateDailyWaterIntake(): Double {
        val multiplier = ageMultiplierProvider.getMultiplierByAge(getAge())
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier)
    }

    // Метод для расчета суточного потребления воды в стаканах
    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake()
        val glassVolume = 250
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume)
    }
}

// Конкретная реализация класса WaterBalance для пользователя с заданным возрастом
class UserWaterBalance(
    private val age: Int,
    weight: Double,
    ageMultiplierProvider: IAgeMultiplierProvider,
    waterIntakeCalculator: IWaterIntakeConverter,
    waterIntakeInGlassesCalculator: IWaterIntakeInGlassesConverter
) : WaterBalance(weight, ageMultiplierProvider, waterIntakeCalculator, waterIntakeInGlassesCalculator) {

    // Переопределение метода для получения возраста пользователя
    override fun getAge(): Int {
        return age
    }
}

// Конкретная реализация интерфейса IAgeMultiplierProvider по умолчанию
class DefaultAgeMultiplierProvider : IAgeMultiplierProvider {
    override fun getMultiplierByAge(age: Int): Double {
        return when {
            age < 14 -> 40.0
            age < 30 -> 35.0
            age < 55 -> 30.0
            else -> 25.0
        }
    }
}

// Конкретная реализация интерфейса IWaterIntakeCalculator по умолчанию
class DefaultWaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier
    }
}

// Конкретная реализация интерфейса IWaterIntakeInGlassesCalculator по умолчанию
class DefaultWaterIntakeInGlassesConvertor : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt()
    }
}
