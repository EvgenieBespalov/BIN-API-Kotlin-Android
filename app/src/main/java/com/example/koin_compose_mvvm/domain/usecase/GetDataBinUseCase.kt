package com.example.koin_compose_mvvm.domain.usecase

import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.repository.BinRepository

class GetDataBinUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(bin: Int): MainData = repository.getData(bin)
}