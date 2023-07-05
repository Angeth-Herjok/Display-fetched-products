package com.example.myshop.Repository

import com.example.myshop.Api.ApiClient
import com.example.myshop.Api.ApiInterface
import com.example.myshop.Model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepository {
    val apiclient =
        ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getProducts():Response<ProductResponse>{
        return  withContext(Dispatchers.IO){
            apiclient.getProducts()
        }


    }
}