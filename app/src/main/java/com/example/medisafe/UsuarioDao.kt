package com.example.medisafe

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    fun obtenerTodos(): LiveData<List<Usuario>>

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Delete
    suspend fun eliminar(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email AND contra = :password LIMIT 1")
    suspend fun autenticar(email: String, password: String): Usuario?
}
