package com.example.myshop.Model

import com.example.myshop.Model.Product

data class ProductResponse (
    var products: List<Product>,
    var total: Int,
    var skip: Int,
    var limit: Int
)