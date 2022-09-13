package com.lloydsbankinggroupcc.di

import android.app.Application
import androidx.room.Room
import com.lloydsbankinggroupcc.data.PetDao
import com.lloydsbankinggroupcc.data.PetDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val petsDataBaseModule = module {

    fun provideDatabase(application: Application): PetDatabase {
        return Room.databaseBuilder(application, PetDatabase::class.java, "pets.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun providePetDatabase(database: PetDatabase): PetDao {
        return database.petsDao
    }


    single { provideDatabase(androidApplication()) }
    single { providePetDatabase(get()) }

}