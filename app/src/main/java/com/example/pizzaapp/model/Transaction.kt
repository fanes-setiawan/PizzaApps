package com.example.pizzaapp.model

data class Transaction(
    val id: Int,
    val total: Double,
    val tax: Double,
    val totalPayment: Double
)
