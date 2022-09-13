package com.lloydsbankinggroupcc.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lloydsbankinggroupcc.data.datamodels.animals.Animals


@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnimals(pets: Animals)

    @Transaction
    @Query("SELECT * FROM Animals")
    fun getAllPets(): LiveData<Animals>

}