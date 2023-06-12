package com.example.watermate.models

// Интерфейс для получения множителя в зависимости от степени обезвоживания
interface IDegreeOfDehydrationMultiplier {
    /**
     * Метод для возвращения множителя от 0.05 до 0.10
     * @param degreeOfDehydration степень обезвоживания от 1 до 3
     * @return множитель в виде дробного числа
     * @throws IllegalArgumentException если степень обезвоживания не в диапазоне от 1 до 3
     */
    fun getMultiplier(degreeOfDehydration: Int): Double
}

// Интерфейс для расчета необходимого объема воды по весу и множителю
interface IWaterIntakeCalculator {
    /**
     * Метод для возвращения объема воды в литрах
     * @param weight вес человека в килограммах
     * @param multiplier множитель в зависимости от степени обезвоживания
     * @return объем воды в литрах в виде дробного числа
     */
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double
}

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

// Класс для получения множителя по степени обезвоживания
class DegreeOfDehydrationMultiplier : IDegreeOfDehydrationMultiplier {
    override fun getMultiplier(degreeOfDehydration: Int): Double {
        return when (degreeOfDehydration) { // Возвращаем множитель в зависимости от значения degreeOfDehydration
            1 -> 0.05 // Слабая степень обезвоживания - множитель 0.05
            2 -> 0.08 // Средняя степень обезвоживания - множитель 0.08
            3 -> 0.10 // Сильная степень обезвоживания - множитель 0.10
            else -> throw IllegalArgumentException("Недопустимый уровень дегидратации") // Все остальные случаи - исключение
        }
    }
}

// Класс для расчета объема воды по весу и множителю
class WaterIntakeConverter : IWaterIntakeConverter {
    override fun calculateWaterIntake(weight: Double, multiplier: Double): Double {
        return weight * multiplier // Возвращаем произведение веса и множителя
    }
}

// Класс для расчета количества стаканов воды по объему воды и объему стакана
class WaterIntakeInGlassesConvertor : IWaterIntakeInGlassesConverter {
    override fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int {
        return (waterIntake / glassVolume).toInt() // Возвращаем целую часть от деления объема воды на объем стакана
    }
}

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
