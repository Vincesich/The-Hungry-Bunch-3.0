package com.example.thehungrybunch30.ui.cart

data class CartItem(
    val imageResId: Int,
    val itemName: String,
    val price: Double,
    var quantity: Int = 1, // Default quantity is 1
    var deliveryOption: Boolean = false // Default delivery option is false (no delivery)
)
