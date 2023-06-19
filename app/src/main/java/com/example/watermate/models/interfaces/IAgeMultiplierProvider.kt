package com.example.watermate.models.interfaces

// Интерфейс для предоставления множителя в зависимости от возраста
interface IAgeMultiplierProvider {
    /**
     * Метод для возвращения множителя по возрасту
     * @param age возраст пользователя в годах
     * @return множитель для расчета потребления воды
     */
    fun getMultiplierByAge(age: Int): Double
}