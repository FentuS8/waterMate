package com.example.watermate.models

interface IAppearanceEvaluator {
    fun evaluateAppearance(): Int
}

interface IEyesEvaluator {
    fun evaluateEyes(): Int
}

interface IMucousEvaluator {
    fun evaluateMucous(): Int
}

interface ITearsEvaluator {
    fun evaluateTears(): Int
}

class DehydrationLevel(
    private val appearanceEvaluator: IAppearanceEvaluator,
    private val eyesEvaluator: IEyesEvaluator,
    private val mucousEvaluator: IMucousEvaluator,
    private val tearsEvaluator: ITearsEvaluator
) {
    fun getPoints(): Int {
        return (
                appearanceEvaluator.evaluateAppearance() +
                        eyesEvaluator.evaluateEyes() +
                        mucousEvaluator.evaluateMucous() +
                        tearsEvaluator.evaluateTears()
                )
    }
}

class DefaultAppearanceEvaluator(private val appearance: String) : IAppearanceEvaluator {
    override fun evaluateAppearance(): Int {
        return when (appearance) {
            "Normal" -> 0
            "Irritable" -> 1
            "Sluggish" -> 2
            else -> 0
        }
    }
}

class DefaultEyesEvaluator(private val eyes: String) : IEyesEvaluator {
    override fun evaluateEyes(): Int {
        return when (eyes) {
            "Normal" -> 0
            "Light sleepiness" -> 1
            "Drowsy" -> 2
            else -> 0
        }
    }
}

class DefaultMucousEvaluator(private val mucous: String) : IMucousEvaluator {
    override fun evaluateMucous(): Int {
        return when (mucous) {
            "Wet" -> 0
            "Sticky" -> 1
            "Dry" -> 2
            else -> 0
        }
    }
}

class DefaultTearsEvaluator(private val tears: String) : ITearsEvaluator {
    override fun evaluateTears(): Int {
        return when (tears) {
            "Yes" -> 0
            "Few" -> 1
            "No" -> 2
            else -> 0
        }
    }
}
