package com.mystikcoder.currencyconverter.data

import com.mystikcoder.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest")
    suspend fun getRates(
        @Query("access_key") accessKey: String,
        @Query("base") base: String
    ): Response<CurrencyResponse>

}