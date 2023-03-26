package com.example.koin_compose_mvvm.di

import com.example.koin_compose_mvvm.presentation.BinHistoryViewModel
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun providePresentationModule(): Module =
    module {
        viewModel {
            FindBinViewModel(
                getDataBinUseCase = get()
            )
        }

        viewModel {
           BinHistoryViewModel()
        }
    }