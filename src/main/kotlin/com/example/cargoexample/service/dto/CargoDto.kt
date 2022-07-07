package com.example.cargoexample.service.dto

data class CargoDto(
    val id: Int = 0,
    val title: String,
    val brand: String? = "",
    val passengerCount: Int? = null,
    val loadCapacity: Int? = null,
)