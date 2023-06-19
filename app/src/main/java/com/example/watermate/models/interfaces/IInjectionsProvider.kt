package com.example.watermate.models.interfaces

// Интерфейс для поставщика инъекций
interface IInjectionsProvider {
    /**
     * Метод для возвращения количества инъекций по возрасту
     * @param age - возраст в годах
     * @return строка с количеством инъекций
     */
    fun getInjections(age: Int): String
}