package com.example.watermate.ui.electrolites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElectrolitesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is electrolites Fragment"
    }
    val text: LiveData<String> = _text
}