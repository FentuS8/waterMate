package com.example.watermate.models

// Интерфейс для получения множителя в зависимости от степени обезвоживания
interface IDegreeOfDehydrationMultiplier {
    fun getMultiplier(degreeOfDehydration: Int): Double // Метод для возвращения множителя от 0.05 до 0.10
}

// Интерфейс для расчета необходимого объема воды по весу и множителю
interface IWaterIntakeCalculator {
    fun calculateWaterIntake(weight: Double, multiplier: Double): Double // Метод для возвращения объема воды в литрах
}

// Интерфейс для расчета необходимого количества стаканов воды по объему воды и объему стакана
interface IWaterIntakeInGlassesCalculator {
    fun calculateWaterIntakeInGlasses(waterIntake: Double, glassVolume: Int): Int // Метод для возвращения количества стаканов воды
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
    fun calculateWaterIntake(weight: Double, degreeOfDehydration: Int): Double {
        val multiplier = degreeOfDehydrationMultiplier.getMultiplier(degreeOfDehydration) // Получаем множитель по степени обезвоживания
        return waterIntakeCalculator.calculateWaterIntake(weight, multiplier) // Возвращаем объем воды по весу и множителю
    }

    fun calculateWaterIntakeInGlasses(weight: Double, degreeOfDehydration: Int): Int {
        val waterIntake = calculateWaterIntake(weight, degreeOfDehydration) // Получаем объем воды по весу и степени обезвоживания
        val glassVolume = 250 // Задаем объем стакана в миллилитрах
        return waterIntakeInGlassesCalculator.calculateWaterIntakeInGlasses(waterIntake, glassVolume) // Возвращаем количество стаканов воды по объему воды и объему стакана
    }
}
