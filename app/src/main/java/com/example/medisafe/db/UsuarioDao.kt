package com.example.medisafe.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.medisafe.db.entities.Usuario
import com.example.medisafe.db.relations.UsuarioMedicamento


@Dao
interface UsuarioDao {


    @Query("SELECT * FROM usuarios WHERE username = :username AND password = :password LIMIT 1")
    suspend fun getUser(username: String, password: String): Usuario?

    @Insert
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    fun obtenerTodos(): LiveData<List<Usuario>>

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Delete
    suspend fun eliminar(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email AND password = :password LIMIT 1")
    suspend fun autenticar(email: String, password: String): Usuario?

    // Relación con medicamentos
    @Transaction
    @Query("SELECT * FROM usuarios WHERE id = :usuarioId")
    fun obtenerUsuarioMedicamento(usuarioId: Int): LiveData<UsuarioMedicamento>
}
