package com.lloydsbankinggroupcc.repository

import android.util.Log
import com.lloydsbankinggroupcc.data.PetDao
import com.lloydsbankinggroupcc.data.datamodels.animals.Animals
import com.lloydsbankinggroupcc.data.datamodels.auth.ErrorResponse400
import com.lloydsbankinggroupcc.network.PetApiService
import com.lloydsbankinggroupcc.util.cast
import com.lloydsbankinggroupcc.util.sharedPref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PetRepository(private val petDao: PetDao, private val apiService: PetApiService) {


    fun fetchPetsFromApi() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val petsResponse = apiService.getListOfPets().await()
                when (petsResponse.code()) {
                    in 200..299 -> {
                        petsResponse.body()?.let { animals ->
                            storePetsData(animals)
                        }
                    }
                    401 -> {
                        sharedPref().authToken = ""
                        delay(2000)
                        authenticateUserAndFetchFromApi()
                    }

                }
            }
        } catch (e: Exception) {
            Log.i("PetFinder", "${this::fetchPetsFromApi.name} ${e.message}")
        }
    }

    private fun authenticateUserAndFetchFromApi() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val authResponse = apiService.authenticate().await()
                when (authResponse.code()) {
                    in 200..299 -> {
                        authResponse.body()?.accessToken?.let {
                            sharedPref().authToken = it
                            delay(3000)
                            fetchPetsFromApi()
                        }
                    }
                    400 -> {
                        cast<ErrorResponse400>(authResponse.body())?.let { error400 ->
                            //saveAuthToken(authData)
                        }
                    }
                    401 -> {
                        cast<ErrorResponse400>(authResponse.body())?.let { error400 ->
                        }
                    }
                    else -> Log.i("PetFinder", "${authResponse.code()}")
                }
            }


        } catch (e: Exception) {
            Log.i("PetFinder", "${this::authenticateUserAndFetchFromApi.name} ${e.message}")
        }
    }

    fun storePetsData(pets: Animals) {
        CoroutineScope(Dispatchers.IO).launch {
            petDao.insertAnimals(pets)
        }
    }

    fun getListOfPets() = petDao.getAllPets()


}