package com.example.koin_compose_mvvm.data.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_data")
data class BinDataBaseModel(
    @PrimaryKey
    val id: String,
    val date: String,
    val bin: String,
    val scheme: String? = null,
    val lengthNumber: String? = null,
    val luhnNumber: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: String? = null,

    val numericCountry: String? = null,
    val alpha2Country: String? = null,
    val nameCountry: String? = null,
    val emojiCountry: String? = null,
    val currencyCountry: String? = null,
    val latitudeCountry: String? = null,
    val longitudeCountry: String? = null,

    val nameBank: String? = null,
    val urlBank: String? = null,
    val phoneBank: String? = null,
    val cityBank: String? = null
)