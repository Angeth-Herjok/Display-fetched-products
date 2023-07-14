package com.example.myshop.Model

data class QuotesResponse (
    var quotes: List<Quotes>,
    var total: Int,
    var skip: Int,
    var limit: Int
)