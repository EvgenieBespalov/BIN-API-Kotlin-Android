package com.example.koin_compose_mvvm.di

import androidx.room.Room
import com.example.koin_compose_mvvm.data.database.BinDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDataBaseModule(): Module =
    module{
        single {
            Room.databaseBuilder(androidApplication(), BinDataBase::class.java, "bin_db")
                .build()
        }

        single { get<BinDataBase>().binDAO() }
    }