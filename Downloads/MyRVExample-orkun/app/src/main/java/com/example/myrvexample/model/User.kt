package com.example.myrvexample.model

data class User(
    val trade_id: String,
    val stock_symbol: String,
    val purchase_price: Double,
    val sale_price: Double,
    val trade_date: String
)
