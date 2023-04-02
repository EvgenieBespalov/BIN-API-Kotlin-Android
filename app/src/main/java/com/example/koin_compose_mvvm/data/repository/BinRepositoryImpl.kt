package com.example.koin_compose_mvvm.data.repository

import com.example.koin_compose_mvvm.data.api.BinApi
import com.example.koin_compose_mvvm.data.converter.BinConverter
import com.example.koin_compose_mvvm.data.dao.BinDAO
import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.repository.BinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BinRepositoryImpl(
    private val BinApi: BinApi,
    private val BinDAO: BinDAO,
    private val converter: BinConverter,
) : BinRepository {
    override suspend fun getDataApi(bin: String): MainData {
        return converter.convertApiBin(BinApi.getDataApi(bin), bin)
    }
    override suspend fun loadBinAllDataBase(): List<MainData> {
        return withContext(Dispatchers.IO) {
            return@withContext BinDAO.findBinAll().map { converter.convertDataBaseToBin(it) }
        }
    }

    override suspend fun loadBinByBinDataBase(bin: String): List<MainData> {
        return withContext(Dispatchers.IO) {
            return@withContext BinDAO.findBinByBin(bin).map { converter.convertDataBaseToBin(it) }
        }
    }

    override suspend fun saveBinDataBase(mainData: MainData) {
        withContext(Dispatchers.IO) {
            BinDAO.saveBinData(converter.convertBinToDataBase(mainData))
        }
    }
}