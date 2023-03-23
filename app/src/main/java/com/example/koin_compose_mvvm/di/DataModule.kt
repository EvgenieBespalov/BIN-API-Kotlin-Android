package com.example.koin_compose_mvvm.di

import com.example.koin_compose_mvvm.data.converter.BinConverter
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDataModule(): Module =
    module {
        factory { BinConverter() }
    }