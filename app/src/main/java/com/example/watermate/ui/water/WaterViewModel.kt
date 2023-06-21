package com.example.watermate.ui.water

import androidx.lifecycle.ViewModel
import com.example.watermate.models.WaterBalance

class WaterViewModel : ViewModel() {
    fun calculateWaterBalance(age: Int, weight: Int): String {
        val waterBalance = WaterBalance(weight.toDouble(), age)

        val dailyWaterIntake = waterBalance.calculateDailyWaterIntake() / 1000
        val dailyWaterIntakeInGlasses = waterBalance.calculateDailyWaterIntakeInGlasses()

        return "You should drink $dailyWaterIntake Liters\n($dailyWaterIntakeInGlasses glasses) of water per day"
    }

}