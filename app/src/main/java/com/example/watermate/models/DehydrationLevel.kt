package com.example.watermate.models

class DehydrationLevel(
    private val appearance: String,
    private val mucous: String,
    private val tears: String,
    private val eyes: String
) {
    /**
     * Метод для вычисления общего количества баллов по всем оценщикам
     * @return сумма баллов всех оценщиков
     */
    fun getPoints(): Int {
        return evaluateAppearance() +
                evaluateMucous() +
                evaluateTears() +
                evaluateEyes()
    }

    /**
     * Метод для оценки по внешнему виду
     */
    private fun evaluateAppearance(): Int {
        return when (appearance) {
            "Normal" -> 0
            "Irritable" -> 1
            "Sluggish" -> 2
            else -> 0
        }
    }

    /**
     * Метод для оценки по состоянию слизистой оболочки рта
     */
    private fun evaluateMucous(): Int {
        return when (mucous) {
            "Wet" -> 0
            "Sticky" -> 1
            "Dry" -> 2
            else -> 0
        }
    }

    /**
     * Метод для оценки по наличию слез при плаче
     */
    private fun evaluateTears(): Int {
        return when (tears) {
            "Yes" -> 0
            "Few" -> 1
            "No" -> 2
            else -> 0
        }
    }

    /**
     * Метод для оценки по состоянию глаз
     */
    private fun evaluateEyes(): Int {
        return when (eyes) {
            "Normal" -> 0
            "Light sleepiness" -> 1
            "Drowsy" -> 2
            else -> 0
        }
    }
}