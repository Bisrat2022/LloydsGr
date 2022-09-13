package com.lloydsbankinggroupcc.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lloydsbankinggroupcc.data.datamodels.animals.Animals

@Database(
    entities =
    [Animals::class], version = 1, exportSchema = false
)

@TypeConverters(TypeConverter::class)
abstract class PetDatabase : RoomDatabase() {
    abstract val petsDao: PetDao
}