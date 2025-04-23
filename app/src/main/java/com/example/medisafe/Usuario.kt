package com.example.medisafe

class Usuario {
    data class Info(
        val id: String = "",
        val nombre: String = "",
        val contra: String = "",
        val email: String = "",
        val telefono: String = "",
        val edad: Int = 0,
        val medications: List<String> = emptyList() // Lista de medicamentos del usuario
    )
}
