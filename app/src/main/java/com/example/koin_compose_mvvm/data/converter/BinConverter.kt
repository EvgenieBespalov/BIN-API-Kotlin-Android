package com.example.koin_compose_mvvm.data.converter

import com.example.koin_compose_mvvm.data.model.api.MainDataApiModel
import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel
import com.example.koin_compose_mvvm.domain.entity.Bank
import com.example.koin_compose_mvvm.domain.entity.Country
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.entity.Number
import java.util.Calendar.getInstance

class BinConverter {
    fun convertApiBin(from: MainDataApiModel, bin: String): MainData =
        MainData(
            bin = bin,
            date = getInstance().toString(),
            scheme = from.scheme,
            type = from.type,
            brand = from.brand,
            prepaid = when(from.prepaid){
                true -> "Yes"
                false -> "No"
                else -> null
            },
            number = Number(
                length = from.number.length.toString(),
                luhn = when(from.number.luhn){
                    true -> "Yes"
                    false -> "No"
                    else -> null
                }
            ),
            country = Country(
                numeric = from.country.numeric,
                alpha2 = from.country.alpha2,
                name = from.country.name,
                emoji = from.country.emoji,
                currency = from.country.currency,
                latitude = from.country.latitude.toString(),
                longitude = from.country.longitude.toString()
            ),
            bank = Bank(
                name = from.bank.name,
                url = from.bank.url,
                phone = from.bank.phone,
                city = from.bank.city
            )
        )

    fun convertDataBaseToBin(from: BinDataBaseModel): MainData =
        MainData(
            bin = from.bin,
            date = from.date,
            scheme = from.scheme,
            type = from.type,
            brand = from.brand,
            prepaid = from.prepaid,
            number = Number(
                length = from.lengthNumber,
                luhn = from.luhnNumber
            ),
            country = Country(
                numeric = from.numericCountry,
                alpha2 = from.alpha2Country,
                name = from.nameCountry,
                emoji = from.emojiCountry,
                currency = from.currencyCountry,
                latitude = from.latitudeCountry,
                longitude = from.longitudeCountry
            ),
            bank = Bank(
                name = from.nameBank,
                url = from.urlBank,
                phone = from.phoneBank,
                city = from.cityBank
            )
        )

    fun convertBinToDataBase(from: MainData): BinDataBaseModel =
        BinDataBaseModel(
            id = "",
            bin = from.bin,
            date = from.date,
            scheme = from.scheme,
            lengthNumber = from.number.length,
            luhnNumber = from.number.luhn,
            type = from.type,
            brand = from.brand,
            prepaid = from.prepaid,

            numericCountry = from.country.numeric,
            alpha2Country = from.country.alpha2,
            nameCountry = from.country.name,
            emojiCountry = from.country.emoji,
            currencyCountry = from.country.currency,
            latitudeCountry = from.country.latitude,
            longitudeCountry = from.country.longitude,

            nameBank = from.bank.name,
            urlBank = from.bank.url,
            phoneBank = from.bank.phone,
            cityBank = from.bank.city
        )
}