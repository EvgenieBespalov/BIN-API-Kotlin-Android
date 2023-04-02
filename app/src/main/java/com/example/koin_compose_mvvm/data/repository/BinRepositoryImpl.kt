package com.example.koin_compose_mvvm.data.repository

import com.example.koin_compose_mvvm.data.api.BinApi
import com.example.koin_compose_mvvm.data.converter.BinConverter
import com.example.koin_compose_mvvm.data.dao.BinDAO
import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.repository.BinRepository

class BinRepositoryImpl(
    private val BinApi: BinApi,
    private val BinDAO: BinDAO,
    private val converter: BinConverter,
) : BinRepository {
    override suspend fun getDataApi(bin: String): MainData {
        return converter.convertApiBin(BinApi.getDataApi(bin), bin)
    }
    override suspend fun findBinAll(): List<MainData> {
        return BinDAO.findBinAll().map { converter.convertDataBaseToBin(it) }
    }

    override suspend fun findBinByBin(bin: String): List<MainData> {
        return BinDAO.findBinByBin(bin).map { converter.convertDataBaseToBin(it) }
    }

    override suspend fun saveBinData(mainData: MainData) {
        BinDAO.saveBinData(converter.convertBinToDataBase(mainData))
    }
}