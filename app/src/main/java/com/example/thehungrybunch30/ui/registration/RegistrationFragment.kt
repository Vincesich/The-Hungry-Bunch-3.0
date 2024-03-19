package com.example.thehungrybunch30.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thehungrybunch30.R
import com.example.thehungrybunch30.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val registerViewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val firstNameEditText = binding.etRegFirstName
        val lastNameEditText = binding.etLastName
        val roomNumberEditText = binding.etRoomNumber
        val phoneNumberEditText = binding.etPhoneNumber
        val emailEditText = binding.etEmail
        val passwordEditText = binding.etPassword
        val confirmPasswordEditText = binding.etConfirmPassword
        auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val roomNumber = roomNumberEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && phoneNumber.isNotEmpty() && roomNumber.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()) {
                if (password == confirmPassword) {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Write user data to Firestore
                                val userId = auth.currentUser?.uid
                                if (userId != null) {
                                    val user = hashMapOf(
                                        "firstName" to firstName,
                                        "lastName" to lastName,
                                        "roomNumber" to roomNumber,
                                        "phoneNumber" to phoneNumber,
                                        // Add other fields as needed
                                    )
                                    FirebaseFirestore.getInstance().collection("users").document(userId)
                                        .set(user)
                                        .addOnSuccessListener {
                                            findNavController().navigate(R.id.navigation_menu)
                                        }
                                        .addOnFailureListener { e ->
                                            Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                                        }
                                } else {
                                    // Handle null user ID
                                }
                            } else {
                                Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(requireContext(), "Passwords Do Not Match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        val navButton: Button = binding.navSignIn
        navButton.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
