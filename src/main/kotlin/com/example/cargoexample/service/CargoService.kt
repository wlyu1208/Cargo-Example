package com.example.cargoexample.service

import com.example.cargoexample.service.dto.CargoDto

interface CargoService {
    fun getAll(pageIndex: Int): List<CargoDto>

    fun getById(id: Int): CargoDto

    fun create(cargoDto: CargoDto): CargoDto

    fun batchCreate(cargoDtos: List<CargoDto>): Int

    fun update(id: Int, cargoDto: CargoDto): CargoDto

    fun delete(id: Int)

    fun getStatistics(): Map<String, Int>
}
