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
                length = when(from.numberApiModel.length){
                    null -> "Non"
                    else -> from.numberApiModel.length.toString()
                                                         },
                luhn = when(from.numberApiModel.luhn){
                    true -> "Yes"
                    false -> "No"
                    else -> "Non"
                }
            ),
            country = Country(
                numeric = from.countryApiModel.numeric,
                alpha2 = from.countryApiModel.alpha2,
                name = from.countryApiModel.name,
                emoji = from.countryApiModel.emoji,
                currency = from.countryApiModel.currency,
                coordinates = from.countryApiModel.latitude.toString() + ", " + from.countryApiModel.longitude.toString()
            ),
            bank = Bank(
                name = from.bankApiModel.name,
                url = from.bankApiModel.url,
                phone = from.bankApiModel.phone,
                city = from.bankApiModel.city
            )
        )

}