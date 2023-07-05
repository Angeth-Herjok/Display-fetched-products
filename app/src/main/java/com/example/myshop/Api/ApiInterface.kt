package com.example.myshop.Api

import com.example.myshop.Model.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
    suspend fun getProducts(): Response<ProductResponse>

    @GET("/products/{id")
    suspend fun getProduct(@Path("id")productId: Int): Response<ProductResponse>
}