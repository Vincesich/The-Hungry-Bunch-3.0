package com.example.thehungrybunch30.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thehungrybunch30.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    private lateinit var binding: FragmentPayBinding


    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val payViewModel =
            ViewModelProvider(this)[PayViewModel::class.java]

        binding = FragmentPayBinding.inflate(layoutInflater)


        val textView: TextView = binding.textNotifications
        payViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return binding.root
    }
}

