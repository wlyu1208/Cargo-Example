package com.example.cargoexample.model

data class Cargo(
    val id: Int = 0,
    val title: String,
    val brand: String? = "",
    val passengerCount: Int? = null,
    val loadCapacity: Int? = null,
)
