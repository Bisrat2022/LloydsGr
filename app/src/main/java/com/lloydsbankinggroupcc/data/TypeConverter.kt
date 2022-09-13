package com.lloydsbankinggroupcc.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lloydsbankinggroupcc.data.datamodels.animals.Animal
import com.lloydsbankinggroupcc.data.datamodels.animals.Pagination
import java.lang.reflect.Type

class TypeConverter {

    @TypeConverter
    fun fromPagination(pagination: Pagination): String {
        return Gson().toJson(pagination)
    }

    @TypeConverter
    fun toPagination(value: String?): Pagination {
        val type: Type = object : TypeToken<Pagination?>() {}.type
        return Gson().fromJson(value, type)
    }


    @TypeConverter
    fun animalsListToJson(pets: List<Animal>): String {
        return Gson().toJson(pets)
    }

    @TypeConverter
    fun animalsListFromJson(value: String): List<Animal> {
        return Gson().fromJson(value, Array<Animal>::class.java).toList()
    }
}