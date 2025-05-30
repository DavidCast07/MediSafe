package com.example.medisafe.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.medisafe.db.entities.Usuario
import com.example.medisafe.db.entities.Medicamento

data class UsuarioMedicamento(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "id",
        entityColumn = "usuarioId"
    )
    val medicamentos: List<Medicamento>
)