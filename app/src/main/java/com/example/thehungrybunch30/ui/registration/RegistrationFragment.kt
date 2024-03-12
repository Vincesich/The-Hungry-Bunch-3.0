package com.example.thehungrybunch30.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentRegisterBinding
import com.example.thehungrybunch30.ui.login.LoginFragment

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
            val fragment = LoginFragment()
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