package com.example.thehungrybunch30.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    private lateinit var binding: FragmentPayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val payViewModel = ViewModelProvider(this)[PayViewModel::class.java]
        binding = FragmentPayBinding.inflate(layoutInflater)

        // Fetch Total Amount
        val totalAmount = arguments?.getString("totalAmount")
        // Set total amount in TextView
        val textViewPay = binding.textPay
        textViewPay.text = totalAmount

        binding.orderMoreFood.setOnClickListener {
            findNavController().navigate(R.id.navigation_menu)
        }

        val textView: TextView = binding.textPay
        payViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }
}

