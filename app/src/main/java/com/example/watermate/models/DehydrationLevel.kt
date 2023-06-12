package com.example.watermate.models

// Интерфейс для оценки уровня обезвоживания по разным параметрам
interface IEvaluator {
    /**
     * Метод для возвращения оценки от 0 до 2
     * @return оценка обезвоживания в виде целого числа от 0 до 2
     */
    fun evaluate(): Int
}

// Класс для вычисления общего количества баллов по всем оценщикам
class DehydrationLevel(private val evaluators: List<IEvaluator>) {
    /**
     * Метод для получения общего количества баллов по всем оценщикам
     * @return сумма баллов всех оценщиков в списке evaluators
     */
    fun getPoints(): Int {
        return evaluators.sumOf { it.evaluate() } // Суммируем оценки всех оценщиков в списке
    }
}

// Класс для оценки по внешнему виду
class DefaultAppearanceEvaluator(private val appearance: String) : IEvaluator {
    /**
     * Метод для оценки по внешнему виду
     * @return оценка в зависимости от значения appearance: 0 - нормальный, 1 - раздражительный, 2 - вялый, иначе - 0
     */
    override fun evaluate(): Int {
        return when (appearance) { // Возвращаем оценку в зависимости от значения appearance
            "Normal" -> 0 // Нормальный внешний вид - 0 баллов
            "Irritable" -> 1 // Раздражительный внешний вид - 1 балл
            "Sluggish" -> 2 // Вялый внешний вид - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}

// Класс для оценки по состоянию глаз
class DefaultEyesEvaluator(private val eyes: String) : IEvaluator {
    /**
     * Метод для оценки по состоянию глаз
     * @return оценка в зависимости от значения eyes: 0 - нормальное, 1 - легкая сонливость, 2 - сонливость, иначе - 0
     */
    override fun evaluate(): Int {
        return when (eyes) { // Возвращаем оценку в зависимости от значения eyes
            "Normal" -> 0 // Нормальное состояние глаз - 0 баллов
            "Light sleepiness" -> 1 // Легкая сонливость - 1 балл
            "Drowsy" -> 2 // Сонливость - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}

// Класс для оценки по состоянию слизистой оболочки рта
class DefaultMucousEvaluator(private val mucous: String) : IEvaluator {
    /**
     * Метод для оценки по состоянию слизистой оболочки рта
     * @return оценка в зависимости от значения mucous: 0 - влажная, 1 - липкая, 2 - сухая, иначе - 0
     */
    override fun evaluate(): Int {
        return when (mucous) { // Возвращаем оценку в зависимости от значения mucous
            "Wet" -> 0 // Влажная слизистая оболочка - 0 баллов
            "Sticky" -> 1 // Липкая слизистая оболочка - 1 балл
            "Dry" -> 2 // Сухая слизистая оболочка - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}

// Класс для оценки по наличию слез при плаче
class DefaultTearsEvaluator(private val tears: String) : IEvaluator {
    /**
     * Метод для оценки по наличию слез при плаче
     * @return оценка в зависимости от значения tears: 0 - есть, 1 - мало, 2 - нет, иначе - 0
     */
    override fun evaluate(): Int {
        return when (tears) { // Возвращаем оценку в зависимости от значения tears
            "Yes" -> 0 // Есть слезы при плаче - 0 баллов
            "Few" -> 1 // Мало слез при плаче - 1 балл
            "No" -> 2 // Нет слез при плаче - 2 балла
            else -> 0 // Все остальные случаи - 0 баллов
        }
    }
}
