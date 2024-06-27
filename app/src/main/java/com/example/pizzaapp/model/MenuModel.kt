package com.example.pizzaapp.model

data class MenuModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: ByteArray
)