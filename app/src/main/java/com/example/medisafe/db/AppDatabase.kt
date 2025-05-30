package com.example.medisafe.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.medisafe.db.entities.Medicamento
import com.example.medisafe.db.entities.Usuario

@Database(entities = [Usuario::class, Medicamento::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "medisafe.db")
                .fallbackToDestructiveMigration() // Solo en desarrollo
                .addCallback(object : RoomDatabase.Callback() {
                })
                .build()
        }

        suspend fun insertDefaultAdmin(context: Context) {
            val usuarioDao = getInstance(context).usuarioDao()
            val admin = usuarioDao.getUser("admin", "123", )

            if (admin == null) {
                usuarioDao.insertar(Usuario(username = "admin", password = "123", email = "eduar.avalos.miranda@gmail.com"))
            }
        }

    }
}

