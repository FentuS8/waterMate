package com.example.watermate.ui.water

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watermate.models.WaterBalance

class WaterViewModel : ViewModel() {
    fun calculateWaterBalance(age: Int, weight: Int): String {
        val waterBalance = WaterBalance(75.0, 35)

        val dailyWaterIntake = waterBalance.calculateDailyWaterIntake()
        val dailyWaterIntakeInGlasses = waterBalance.calculateDailyWaterIntakeInGlasses()

        return "You should drink $dailyWaterIntake ($dailyWaterIntakeInGlasses glasses) of water per day"
    }
}