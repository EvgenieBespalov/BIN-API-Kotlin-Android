package com.example.koin_compose_mvvm.di

import com.example.koin_compose_mvvm.data.api.BinApi
import com.example.koin_compose_mvvm.data.converter.BinConverter
import com.example.koin_compose_mvvm.data.repository.BinRepositoryImpl
import com.example.koin_compose_mvvm.domain.repository.BinRepository
import com.example.koin_compose_mvvm.domain.usecase.GetDataBinUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideBinApiRepository(binApi: BinApi, converter: BinConverter): BinRepository = BinRepositoryImpl(binApi, converter)

fun provideDomainModule(): Module =
    module {
        single { provideBinApiRepository(binApi = get(), converter = get()) }

        factory { GetDataBinUseCase(repository = get()) }
    }