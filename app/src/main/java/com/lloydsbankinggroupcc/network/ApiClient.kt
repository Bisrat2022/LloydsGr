package com.lloydsbankinggroupcc.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lloydsbankinggroupcc.BuildConfig
import com.lloydsbankinggroupcc.util.Constants
import com.lloydsbankinggroupcc.util.SharedPref
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null

    private fun getHeaderInterceptor(): Interceptor {
        val authToken = SharedPref().authToken
        return if (authToken.isEmpty()) {
            Interceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .build()
                chain.proceed(request)
            }
        } else {
            Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", "Bearer $authToken")
                        .build()
                )
            }
        }
    }

    fun provideOKHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(getHeaderInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            })
            .dispatcher(Dispatcher().apply {
                maxRequests = 1
            })
        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun getRetrofitClient(factory: Gson, okHttpClient: OkHttpClient): Retrofit {
        return retrofit ?: synchronized(this) {
            retrofit ?: Retrofit.Builder()
                .baseUrl(Constants.PET_FINDER_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(factory))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }
    }

    fun resetRetrofitClient() {
        retrofit = null
    }
}