package com.example.koin_compose_mvvm.data.converter

import com.example.koin_compose_mvvm.data.model.MainDataApiModel
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
                else -> "Non"
            },
            number = Number(
                length = when(from.number.length){
                    null -> "Non"
                    else -> from.number.length.toString()
                                                         },
                luhn = when(from.number.luhn){
                    true -> "Yes"
                    false -> "No"
                    else -> "Non"
                }
            ),
            country = Country(
                numeric = from.country.numeric,
                alpha2 = from.country.alpha2,
                name = from.country.name,
                emoji = from.country.emoji,
                currency = from.country.currency,
                coordinates = from.country.latitude.toString() + ", " + from.country.longitude.toString()
            ),
            bank = Bank(
                name = when(from.bank.name){
                    null -> "Non"
                    else -> from.bank.name
                },
                url = when(from.bank.url){
                    null -> "Non"
                    else -> from.bank.url
                },
                phone = when(from.bank.phone){
                    null -> "Non"
                    else -> from.bank.phone
                },
                city = when(from.bank.city){
                    null -> "Non"
                    else -> from.bank.city
                },
            )
        )

}