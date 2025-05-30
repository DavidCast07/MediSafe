package com.example.medisafe.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String = "",
    val password: String = "",
    val email: String = "",
    val telefono: String = "",
    val edad: Int = 0,

)
