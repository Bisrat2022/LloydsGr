package com.lloydsbankinggroupcc.repository

import com.lloydsbankinggroupcc.data.PetDao
import com.lloydsbankinggroupcc.data.datamodels.animals.Animals
import com.lloydsbankinggroupcc.network.PetApiService
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class PetRepositoryTest {

    lateinit var petDao: PetDao
    lateinit var petApiService: PetApiService
    lateinit var petRepository: PetRepository

    @Before
    fun setup() {
        petDao = mock(PetDao::class.java)
        petApiService = mock(PetApiService::class.java)
        petRepository = PetRepository(petDao, petApiService)
    }

    @Test
    fun whenFetchApi_thenStorePetDataIsCalled() {
        val petResponse = Animals(1, emptyList(), null)
        doNothing().`when`(petDao).insertAnimals(petResponse)

        petRepository.storePetsData(petResponse)

        verify(petDao).insertAnimals(petResponse)
    }
}