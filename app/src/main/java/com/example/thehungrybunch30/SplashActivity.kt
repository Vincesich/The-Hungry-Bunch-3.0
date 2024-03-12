package com.example.thehungrybunch30

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thehungrybunch30.databinding.ActivitySplashBinding
import com.example.thehungrybunch30.ui.login.LoginFragment

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // By default when the app is opened the Login fragment appears
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_container, LoginFragment())
            .commit()

    }
}