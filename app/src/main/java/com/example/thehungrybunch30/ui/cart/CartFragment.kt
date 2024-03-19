package com.example.thehungrybunch30.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thehungrybunch30.R
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
        // Retrieve data passed from MenuFragment
        val imageResId = arguments?.getInt("imageResId", 0)
        val itemName = arguments?.getString("itemName")
        val price = arguments?.getDouble("price", 0.0)
        val deliveryFee = arguments?.getDouble("deliveryFee", 0.0)
        // Update UI with retrieved data
        if (imageResId != null) {
            val imageView = binding.checkoutMealImage
            imageView.setImageResource(imageResId)
        }
        binding.checkoutMealChosen.text = getString(R.string.checkout_meal_chosen, itemName)
        binding.checkoutSubtotalFee.text = getString(R.string.checkout_subtotal_fee, price)
        binding.checkoutTotalFee.text = getString(R.string.checkout_subtotal_fee, price)


        // Set up TextView to display quantity
        val quantityTextView: TextView = binding.displayQuantity
        quantityTextView.text = quantity.toString()

        // Set up switch to display delivery option
        val deliverySwitch: MaterialSwitch = binding.deliverySwitch
        val deliveryFeeTextView: TextView = binding.checkoutDeliveryFee
        val totalFeeTextView: TextView = binding.checkoutTotalFee

        // Set initial state of switch and delivery fee text
        deliverySwitch.isChecked = deliveryOption
        deliveryFeeTextView.text = if (deliveryOption) getString(R.string.delivery_fee) else getString(R.string.no_delivery_fee)

        // Set up listener for delivery option switch
        deliverySwitch.setOnCheckedChangeListener { _, isChecked ->
            // Update delivery fee text based on switch state
            deliveryOption = isChecked
            deliveryFeeTextView.text = if (isChecked) getString(R.string.delivery_fee) else getString(R.string.no_delivery_fee)
            // Update total fee based on delivery option
            updateTotalFee()
        }


        binding.purchaseButton.setOnClickListener {
        /* Implement purchase logic here */
        }
        binding.addQuantityButton.setOnClickListener {
            increaseQuantityAndTotal()
        }

        binding.reduceQuantityButton.setOnClickListener {
            decreaseQuantityAndTotal()
        }


        val textView: TextView = binding.textDashboard
        cartViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    // Function to increase quantity and update total
    private fun increaseQuantityAndTotal() {
        quantity++
        updateQuantityUI()
        updateTotalFee()
    }

    // Function to decrease quantity and update total
    private fun decreaseQuantityAndTotal() {
        if (quantity > 1) {
            quantity--
            updateQuantityUI()
            updateTotalFee()
        }
    }

    // Function to update Total fee
    private fun updateTotalFee() {
        val price = arguments?.getDouble("price", 0.0) ?: 0.0
        val deliveryFee = if (deliveryOption) 50.0 else 0.0
        val subtotal = price * quantity
        val totalFee = subtotal + deliveryFee
        binding.checkoutTotalFee.text = getString(R.string.checkout_total_fee, totalFee)
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