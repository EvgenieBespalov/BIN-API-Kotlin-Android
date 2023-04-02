package com.example.koin_compose_mvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel

@Dao
interface BinDAO {
    @Insert
    fun saveBinData(entities: BinDataBaseModel)

    @Query("SELECT * FROM bin_data WHERE bin = :bin")
    fun findBinByBin(bin: String): List<BinDataBaseModel>

    @Query("SELECT * FROM bin_data")
    fun findBinAll(): List<BinDataBaseModel>
}