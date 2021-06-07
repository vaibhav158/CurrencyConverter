package com.mystikcoder.currencyconverter.main

import com.mystikcoder.currencyconverter.data.models.CurrencyResponse
import com.mystikcoder.currencyconverter.utils.Resource

interface MainRepository {

    suspend fun getRates(access_key: String, base: String): Resource<CurrencyResponse>

}