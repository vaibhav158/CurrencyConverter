package com.mystikcoder.currencyconverter.main

import com.mystikcoder.currencyconverter.data.CurrencyApi
import com.mystikcoder.currencyconverter.data.models.CurrencyResponse
import com.mystikcoder.currencyconverter.utils.Constants.ACCESS_KEY
import com.mystikcoder.currencyconverter.utils.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository{
    override suspend fun getRates(access_key: String, base: String): Resource<CurrencyResponse> {
        return try {

            val response = api.getRates(ACCESS_KEY, base)
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resource.Success(result)
            }else {
                Resource.Error(response.message())
            }

        }catch (e:Exception){
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}