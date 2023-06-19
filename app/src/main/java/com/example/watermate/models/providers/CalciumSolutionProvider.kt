package com.example.watermate.models.providers

import com.example.watermate.models.interfaces.ISolutionProvider

// Конкретный класс для поставщика раствора кальция
class CalciumSolutionProvider : ISolutionProvider {
    /**
     * Метод для возвращения раствора кальция
     * @param element - название элемента (должно быть "Calcium")
     * @return строка с раствором кальция
     */
    override fun getSolution(element: String): String {
        return "0.5 ml/day (calcium chloride) - 1.0 ml/day (calcium gluconate)" // Возвращаем раствор кальция в виде строки
    }
}