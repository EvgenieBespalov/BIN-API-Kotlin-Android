package com.example.koin_compose_mvvm.data.repository

import com.example.koin_compose_mvvm.data.api.BinApi
import com.example.koin_compose_mvvm.data.converter.BinConverter
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.repository.BinRepository

class BinRepositoryImpl(
    private val BinApi: BinApi,
    private val converter: BinConverter,
) : BinRepository {
    override suspend fun getData(bin: Int): MainData {
        return BinApi.getData(bin)
    }
}