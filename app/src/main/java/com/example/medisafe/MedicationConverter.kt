package com.example.medisafe

import androidx.room.TypeConverter

class MedicationConverter {

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun fromStringToList(data: String): List<String> {
        return if (data.isEmpty()) emptyList() else data.split(",")
    }
}
