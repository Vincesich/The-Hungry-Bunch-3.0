package com.example.thehungrybunch30.ui.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
            value = "Thank You For Your Order!"
    }
    val text: LiveData<String> = _text
}