package com.example.medisafe

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "usuarios")
@TypeConverters(MedicationConverter::class)
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String = "",
    val contra: String = "",
    val email: String = "",
    val telefono: String = "",
    val edad: Int = 0,
    val medications: List<String> = emptyList()
)
