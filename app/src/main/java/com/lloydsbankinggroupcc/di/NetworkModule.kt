package com.lloydsbankinggroupcc.di

import com.lloydsbankinggroupcc.network.ApiClient.getRetrofitClient
import com.lloydsbankinggroupcc.network.ApiClient.provideGson
import com.lloydsbankinggroupcc.network.ApiClient.provideOKHttpClient
import org.koin.dsl.module

val networkModule = module {

    single { provideOKHttpClient() }
    single { provideGson() }
    single { getRetrofitClient(get(), get()) }
}