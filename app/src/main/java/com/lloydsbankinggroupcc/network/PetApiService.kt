package com.lloydsbankinggroupcc.network

import com.lloydsbankinggroupcc.data.datamodels.animals.Animals
import com.lloydsbankinggroupcc.data.datamodels.auth.AuthResponse
import com.lloydsbankinggroupcc.data.datamodels.auth.Authenticate
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PetApiService {
    @POST("oauth2/token")
    fun authenticate(@Body authenticate: Authenticate = Authenticate())
            : Deferred<Response<AuthResponse>>

    @GET("animals")
    fun getListOfPets(): Deferred<Response<Animals>>

}