package com.example.thehungrybunch30.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentLoginBinding
import com.example.thehungrybunch30.ui.registration.RegistrationFragment

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

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
            val fragment = RegistrationFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.registration_slide_in_from_right, R.anim.registration_slide_out_to_right)
            transaction.replace(R.id.nav_container, fragment)
            transaction.addToBackStack(null) // back navigation
            transaction.commit()

        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}