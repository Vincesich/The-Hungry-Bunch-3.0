package com.example.thehungrybunch30.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentRegisterBinding

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val registerViewModel =
            ViewModelProvider(this)[RegistrationViewModel::class.java]

        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val textView: TextView = binding.tvRegFirstName
        registerViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val navButton: Button = binding.navSignIn
        navButton.setOnClickListener{
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}