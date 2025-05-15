package com.example.medisafe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.medisafe.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var usuarioDao: UsuarioDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioDao = AppDatabase.getDatabase(this).usuarioDao()

        binding.registerButton.setOnClickListener {
            val nombre = binding.nameInput.text.toString().trim()
            val email = binding.emailInput.text.toString().trim()
            val pass = binding.passwordInput.text.toString().trim()
            val telefono = binding.phoneInput.text.toString().trim()
            val edad = binding.ageInput.text.toString().toIntOrNull() ?: 0

            if (nombre.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nuevoUsuario = Usuario(
                nombre = nombre,
                email = email,
                contra = pass,
                telefono = telefono,
                edad = edad,
                medications = emptyList()
            )

            lifecycleScope.launch {
                usuarioDao.insertar(nuevoUsuario)
                Toast.makeText(this@RegisterActivity, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                finish() // volver al login
            }
        }
    }
}
