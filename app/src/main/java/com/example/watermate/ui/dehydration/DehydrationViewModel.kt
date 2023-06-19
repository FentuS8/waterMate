package com.example.watermate.ui.dehydration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watermate.models.evaluators.DefaultAppearanceEvaluator
import com.example.watermate.models.evaluators.DefaultEyesEvaluator
import com.example.watermate.models.evaluators.DefaultMucousEvaluator
import com.example.watermate.models.evaluators.DefaultTearsEvaluator
import com.example.watermate.models.DehydrationLevel

class DehydrationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dehydration Fragment"
    }
    val text: LiveData<String> = _text

    fun calculateDehydration(appearanceValue: Int, eyesValue: Int, mucousValue: Int, tearsValue: Int): String {
        val eyesEvaluator: DefaultEyesEvaluator
        val appearanceEvaluator: DefaultAppearanceEvaluator
        val mucousEvaluator: DefaultMucousEvaluator
        val tearsEvaluator: DefaultTearsEvaluator

        when (eyesValue) {
            0 -> eyesEvaluator =  DefaultEyesEvaluator("Normal")
            1 -> eyesEvaluator = DefaultEyesEvaluator("Light sleepiness")
            2 -> eyesEvaluator = DefaultEyesEvaluator("Drowsy")
            else -> eyesEvaluator = DefaultEyesEvaluator("None")
        }
        when (appearanceValue) {
            0 -> appearanceEvaluator = DefaultAppearanceEvaluator("Normal")
            1 -> appearanceEvaluator = DefaultAppearanceEvaluator("Irritable")
            2 -> appearanceEvaluator = DefaultAppearanceEvaluator("Sluggish")
            else -> appearanceEvaluator = DefaultAppearanceEvaluator("None")
        }
        when (mucousValue) {
            0 -> mucousEvaluator = DefaultMucousEvaluator("Wet")
            1 -> mucousEvaluator = DefaultMucousEvaluator("Sticky")
            2 -> mucousEvaluator = DefaultMucousEvaluator("Dry")
            else -> mucousEvaluator = DefaultMucousEvaluator("None")
        }
        when (tearsValue) {
            0 -> tearsEvaluator = DefaultTearsEvaluator("Yes")
            1 -> tearsEvaluator = DefaultTearsEvaluator("Few")
            2 -> tearsEvaluator = DefaultTearsEvaluator("No")
            else -> tearsEvaluator = DefaultTearsEvaluator("None")
        }

        val dehydrationLevel = DehydrationLevel(listOf(eyesEvaluator, appearanceEvaluator, mucousEvaluator, tearsEvaluator))

        val points = dehydrationLevel.getPoints()

        return "Количество очков: $points"
    }
}