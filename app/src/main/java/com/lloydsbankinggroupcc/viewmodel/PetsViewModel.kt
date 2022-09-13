package com.lloydsbankinggroupcc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lloydsbankinggroupcc.repository.PetRepository
import com.lloydsbankinggroupcc.util.DataState
import kotlinx.coroutines.launch

class PetsViewModel(private val petRepository: PetRepository) : ViewModel() {


    private val _dataState = MutableLiveData<DataState>()
    val dataState: LiveData<DataState>
        get() = _dataState

    val petsData = petRepository.getListOfPets()

    fun getListOfPets() {
        viewModelScope.launch {
            try {
                _dataState.value = DataState.LOADING
                petRepository.fetchPetsFromApi()
                _dataState.value = DataState.SUCCESS
            } catch (ex: Exception) {
                //  _dataState.value = DataState.logError(ex.localizedMessage)
            }
        }
    }


}