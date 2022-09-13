package com.lloydsbankinggroupcc.di

import com.lloydsbankinggroupcc.network.PetApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun petApiService(retrofit: Retrofit): PetApiService {
        return retrofit.create(PetApiService::class.java)
    }

    single { petApiService(get()) }
}