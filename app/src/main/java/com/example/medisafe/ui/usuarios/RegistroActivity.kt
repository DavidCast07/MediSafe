package com.example.medisafe.ui.usuarios

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.medisafe.databinding.RegistroActivityBinding
import com.example.medisafe.db.AppDatabase
import com.example.medisafe.db.UsuarioDao
import com.example.medisafe.db.entities.Usuario
import kotlinx.coroutines.launch
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: RegistroActivityBinding
    private lateinit var usuarioDao: UsuarioDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioDao = AppDatabase.getInstance(this).usuarioDao()


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
                username = nombre,
                email = email,
                password = pass,
                telefono = telefono,
                edad = edad
            )

            lifecycleScope.launch {
                usuarioDao.insertar(nuevoUsuario)
                Toast.makeText(this@RegisterActivity, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                finish() // volver al login
            }
        }
    }
}
