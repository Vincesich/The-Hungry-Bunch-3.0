package com.example.thehungrybunch30.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Don't already have an account?"
    }
    val text: LiveData<String> = _text
}