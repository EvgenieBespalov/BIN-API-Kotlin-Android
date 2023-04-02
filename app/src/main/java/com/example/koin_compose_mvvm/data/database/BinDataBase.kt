package com.example.koin_compose_mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koin_compose_mvvm.data.dao.BinDAO
import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel

@Database(entities = [BinDataBaseModel::class], version = 3)
abstract class BinDataBase : RoomDatabase() {
    abstract fun binDAO() : BinDAO
}