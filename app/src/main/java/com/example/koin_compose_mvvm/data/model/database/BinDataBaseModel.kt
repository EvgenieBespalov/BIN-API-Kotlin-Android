package com.example.koin_compose_mvvm.data.model.database

data class BinDataBaseModel(
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
    val coordinatesCountry: String? = null,

    val nameBank: String? = null,
    val urlBank: String? = null,
    val phoneBank: String? = null,
    val cityBank: String? = null
)