package com.example.koin_compose_mvvm.data.converter

import com.example.koin_compose_mvvm.data.model.api.MainDataApiModel
import com.example.koin_compose_mvvm.domain.entity.Bank
import com.example.koin_compose_mvvm.domain.entity.Country
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.domain.entity.Number

class BinConverter {
    fun convertBin(from: MainDataApiModel): MainData =
        MainData(
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

}