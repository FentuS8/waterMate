package com.example.watermate.ui.dehydration_treatment

import androidx.lifecycle.ViewModel
import com.example.watermate.models.DehydrationTreatment

class DehydrationTreatmentViewModel : ViewModel() {
    fun calculateDehydrationTreatment(selectedDegree: Int, selectedAge: Int, selectedWeight: Int): String {

        val dehydrationTreatment = DehydrationTreatment()

        val waterIntake = String.format("%.2f", dehydrationTreatment.calculateWaterIntake(selectedWeight.toDouble(), selectedAge, selectedDegree))
        val waterIntakeInGlasses = dehydrationTreatment.calculateWaterIntakeInGlasses(selectedWeight.toDouble(), selectedAge, selectedDegree)

        return "You should drink $waterIntake Liters \n($waterIntakeInGlasses glasses) of water per day"
    }
}