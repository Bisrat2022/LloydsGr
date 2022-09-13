package com.lloydsbankinggroupcc.ui

import com.lloydsbankinggroupcc.data.datamodels.animals.Animal

interface PetsClickListener {

    fun onPetItemClick(pet: Animal)
}