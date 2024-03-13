package com.example.thehungrybunch30.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thehungrybunch30.MainActivity
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private lateinit var context: Context

    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel =
            ViewModelProvider(this)[LoginViewModel::class.java]

        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val textView: TextView = binding.tvLogin
        loginViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        val registrationButton: Button = binding.navRegistration
        // Set click listener for the registration button
        registrationButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        val testNavButton: Button = binding.testNavButton
        testNavButton.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}