package com.example.watermate.models

import com.example.watermate.utils.interfaces.IInjectionsProvider
import com.example.watermate.utils.interfaces.ISolutionProvider

// Конкретный класс для кальция
class Calcium(
    age: Int,
    solutionProvider: ISolutionProvider,
    injectionsProvider: IInjectionsProvider
) : Electrolytes("Calcium", age, solutionProvider, injectionsProvider) // Наследуемся от абстрактного класса электролитов и передаем параметры
