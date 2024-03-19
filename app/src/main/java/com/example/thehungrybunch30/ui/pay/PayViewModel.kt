package com.example.thehungrybunch30.ui.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Pay Here"
    }
    val text: LiveData<String> = _text
}