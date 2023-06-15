package com.example.watermate.ui.dehydratation_treatment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DehydratationTreatmentViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Dehydratation Treatment Fragment"
    }
    val text: LiveData<String> = _text
}