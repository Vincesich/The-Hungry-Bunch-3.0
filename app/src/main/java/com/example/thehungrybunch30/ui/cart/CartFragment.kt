package com.example.thehungrybunch30.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thehungrybunch30.databinding.FragmentCartBinding
import com.google.android.material.materialswitch.MaterialSwitch

class CartFragment : Fragment() {
    private val binding get() = _binding!!
    private var _binding: FragmentCartBinding? = null
    private var quantity: Int = 1
    private var deliveryOption: Boolean = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // Set up TextView to display quantity
        val quantityTextView: TextView = binding.displayQuantity
        quantityTextView.text = quantity.toString()

        // Set up switch to display delivery option
        val deliverySwitch: MaterialSwitch = binding.deliverySwitch
        val deliveryFeeTextView: TextView = binding.checkoutDeliveryFee

        // Set initial state of switch and delivery fee text
        deliverySwitch.isChecked = deliveryOption
        deliveryFeeTextView.text = if (deliveryOption) "50" else "0"

        // Set up listener for delivery option switch
        deliverySwitch.setOnCheckedChangeListener { _, isChecked ->
            // Update delivery fee text based on switch state
            deliveryOption = isChecked
            deliveryFeeTextView.text = if (isChecked) "50" else "0"
        }


        binding.purchaseButton.setOnClickListener {
        /* Implement purchase logic here */
        }
        binding.addQuantityButton.setOnClickListener {
            increaseQuantity()
        }

        binding.reduceQuantityButton.setOnClickListener {
            decreaseQuantity()
        }


        val textView: TextView = binding.textDashboard
        cartViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    // Function to increase quantity
    private fun increaseQuantity() {
        quantity++
        updateQuantityUI()
    }

    // Function to decrease quantity
    private fun decreaseQuantity() {
        if (quantity > 1) {
            quantity--
            updateQuantityUI()
        }
    }

    // Function to update UI with current quantity
    private fun updateQuantityUI() {
        binding.displayQuantity.text = quantity.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}