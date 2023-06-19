package com.example.watermate.ui.dehydration_treatment

import androidx.lifecycle.ViewModel
import com.example.watermate.models.DehydrationTreatment

class DehydrationTreatmentViewModel : ViewModel() {
    fun calculateDehydrationTreatment(selectedDegree: Int, selectedAge: Int, selectedWeight: Int): String {

        val dehydrationTreatment = DehydrationTreatment()

        val waterIntake = dehydrationTreatment.calculateWaterIntake(selectedWeight.toDouble(), selectedDegree)
        val waterIntakeInGlasses = dehydrationTreatment.calculateWaterIntakeInGlasses(selectedWeight.toDouble(), selectedDegree)

        return "You should drink $waterIntake ml ($waterIntakeInGlasses glasses) of water per day"
    }
}