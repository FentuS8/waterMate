package com.example.watermate.ui.dehydratation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DehydratationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dehydratation Fragment"
    }
    val text: LiveData<String> = _text
}