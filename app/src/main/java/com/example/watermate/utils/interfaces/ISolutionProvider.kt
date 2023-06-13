package com.example.watermate.utils.interfaces

// Интерфейс для поставщика раствора
interface ISolutionProvider {
    /**
     * Метод для возвращения раствора по элементу
     * @param element - название элемента
     * @return строка с раствором
     */
    fun getSolution(element: String): String
}