package com.example.watermate.utils.providers

import com.example.watermate.utils.interfaces.IAgeMultiplierProvider

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