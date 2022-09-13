package com.lloydsbankinggroupcc.di

import com.lloydsbankinggroupcc.data.PetDao
import com.lloydsbankinggroupcc.network.PetApiService
import com.lloydsbankinggroupcc.repository.PetRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideRepository(petDao: PetDao, apiService: PetApiService): PetRepository {
        return PetRepository(petDao, apiService)
    }

    single { provideRepository(get(), get()) }
}