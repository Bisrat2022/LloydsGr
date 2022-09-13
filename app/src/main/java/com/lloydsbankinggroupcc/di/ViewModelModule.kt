package com.lloydsbankinggroupcc.di

import com.lloydsbankinggroupcc.viewmodel.PetsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PetsViewModel(get()) }
}