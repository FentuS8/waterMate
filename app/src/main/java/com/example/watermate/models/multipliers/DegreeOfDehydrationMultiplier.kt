package com.example.watermate.models.multipliers

import com.example.watermate.utils.interfaces.IDegreeOfDehydrationMultiplier

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