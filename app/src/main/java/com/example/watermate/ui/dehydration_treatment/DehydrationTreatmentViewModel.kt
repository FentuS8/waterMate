package com.example.watermate.ui.dehydration_treatment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DehydrationTreatmentViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Dehydratation Treatment Fragment"
    }
    val text: LiveData<String> = _text
}