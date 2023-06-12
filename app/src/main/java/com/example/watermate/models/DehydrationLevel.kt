package com.example.watermate.models

interface IEvaluator {
    fun evaluate(): Int
}

class DehydrationLevel(private val evaluators: List<IEvaluator>) {
    fun getPoints(): Int {
        return evaluators.sumOf { it.evaluate() }
    }
}

class DefaultAppearanceEvaluator(private val appearance: String) : IEvaluator {
    override fun evaluate(): Int {
        return when (appearance) {
            "Normal" -> 0
            "Irritable" -> 1
            "Sluggish" -> 2
            else -> 0
        }
    }
}

class DefaultEyesEvaluator(private val eyes: String) : IEvaluator {
    override fun evaluate(): Int {
        return when (eyes) {
            "Normal" -> 0
            "Light sleepiness" -> 1
            "Drowsy" -> 2
            else -> 0
        }
    }
}

class DefaultMucousEvaluator(private val mucous: String) : IEvaluator {
    override fun evaluate(): Int {
        return when (mucous) {
            "Wet" -> 0
            "Sticky" -> 1
            "Dry" -> 2
            else -> 0
        }
    }
}

class DefaultTearsEvaluator(private val tears: String) : IEvaluator {
    override fun evaluate(): Int {
        return when (tears) {
            "Yes" -> 0
            "Few" -> 1
            "No" -> 2
            else -> 0
        }
    }
}
