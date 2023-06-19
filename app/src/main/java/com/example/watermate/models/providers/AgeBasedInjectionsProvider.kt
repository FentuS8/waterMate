package com.example.watermate.models.providers
import com.example.watermate.models.interfaces.IInjectionsProvider

// Конкретный класс для поставщика инъекций по возрасту
class AgeBasedInjectionsProvider : IInjectionsProvider {
    /**
     * Метод для возвращения количества инъекций по возрасту
     * @param age - возраст в годах
     * @return строка с количеством инъекций в зависимости от возраста
     */
    override fun getInjections(age: Int): String {
        return when (age) { // Возвращаем количество инъекций в зависимости от значения age
            in 1..2 -> "1-2" // Для возраста от 1 до 2 лет - 1-2 инъекции
            else -> "1-10" // Для всех остальных случаев - 1-10 инъекций
        }
    }
}