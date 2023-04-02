package com.example.koin_compose_mvvm.domain.usecase

import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.repository.BinRepository

class LoadBinHistoryUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(): List<MainData> = repository.loadBinAllDataBase()
}