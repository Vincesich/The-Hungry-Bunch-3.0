package com.example.thehungrybunch30.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Register"
    }
    val text: LiveData<String> = _text
}