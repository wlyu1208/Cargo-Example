package com.example.cargoexample.repository

import com.example.cargoexample.model.CarBrand

interface CarBrandRepository {
    fun findById(id:Int): CarBrand?
}