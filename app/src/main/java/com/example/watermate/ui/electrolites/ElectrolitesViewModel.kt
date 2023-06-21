package com.example.watermate.ui.electrolites

import androidx.lifecycle.ViewModel
import com.example.watermate.models.Electrolites

class ElectrolitesViewModel : ViewModel() {
    fun calculateElectrolites(selectedElement: String, selectedAge: Int): String {
        val electrolites = Electrolites(selectedElement, selectedAge)

        return electrolites.getInfo()
    }
}