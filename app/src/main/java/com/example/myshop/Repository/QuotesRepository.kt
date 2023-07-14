package com.example.myshop.Repository

import com.example.myshop.Api.ApiClient
import com.example.myshop.Api.ApiInterface
import com.example.myshop.Model.ProductResponse
import com.example.myshop.Model.QuotesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuotesRepository {
    val apiclient =
        ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getQuotes():Response<QuotesResponse>{
        return  withContext(Dispatchers.IO){
            apiclient.getQuotes()
        }


    }
}