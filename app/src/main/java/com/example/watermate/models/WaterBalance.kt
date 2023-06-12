package com.example.watermate.models

// Интерфейс для предоставления множителя в зависимости от возраста
interface IAgeMultiplierProvider {
    /**
     * Метод для возвращения множителя по возрасту
     * @param age возраст пользователя в годах
     * @return множитель для расчета потребления воды
     */
    fun getMultiplierByAge(age: Int): Double
}

// Интерфейс для расчета потребления воды в зависимости от веса и множителя
interface IWaterIntakeConverter {
    /**
     * Метод для возвращения потребления воды в литрах по весу и множителю
     * @param weight вес пользователя в килограммах
     * @param multiplier множитель для расчета потребления воды
     * @return потребление воды в литрах
     */
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

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
        val multiplier = ageMultiplierProvider.getMultiplierByAge(getAge()) // Получаем множитель по возрасту пользователя
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier) // Возвращаем потребление воды по весу и множителю
    }

    // Метод для расчета суточного потребления воды в стаканах
    fun calculateDailyWaterIntakeInGlasses(): Int {
        val waterIntake = calculateDailyWaterIntake() // Получаем потребление воды по весу и возрасту пользователя
        val glassVolume = 250 // Задаем объем стакана в миллилитрах
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume) // Возвращаем потребление воды в стаканах по объему воды и объему стакана
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
        return age // Возвращаем заданный возраст пользователя
    }
}

// Конкретная реализация интерфейса IAgeMultiplierProvider по умолчанию
class DefaultAgeMultiplierProvider : IAgeMultiplierProvider {
    override fun getMultiplierByAge(age: Int): Double {
        return when { // Возвращаем множитель по возрасту пользователя
            age < 14 -> 40.0 // Для возраста до 14 лет - множитель 40.0
            age < 30 -> 35.0 // Для возраста от 14 до 30 лет - множитель 35.0
            age < 55 -> 30.0 // Для возраста от 30 до 55 лет - множитель 30.0
            else -> 25.0 // Для возраста свыше 55 лет - множитель 25.0
        }
    }
}

// Конкретная реализация интерфейса IWaterIntakeCalculator по умолчанию
class DefaultWaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier // Возвращаем произведение веса и множителя
    }
}

// Конкретная реализация интерфейса IWaterIntakeInGlassesConverter по умолчанию
class DefaultWaterIntakeInGlassesConvertor : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt() // Возвращаем целую часть от деления объема воды на объем стакана
    }
}
