package com.example.watermate.ui.dehydration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DehydrationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dehydration Fragment"
    }
    val text: LiveData<String> = _text
}