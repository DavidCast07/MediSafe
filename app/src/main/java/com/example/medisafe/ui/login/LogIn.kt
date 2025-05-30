package com.example.medisafe.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.medisafe.databinding.LogInBinding
import com.example.medisafe.db.AppDatabase
import com.example.medisafe.ui.Home
import kotlinx.coroutines.launch



class LogIn : AppCompatActivity() {

    private lateinit var binding: LogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioDao = AppDatabase.getInstance(this).usuarioDao()

        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()
            startActivity(Intent(this@LogIn, Home::class.java))
            finish()

        }

    }
}
