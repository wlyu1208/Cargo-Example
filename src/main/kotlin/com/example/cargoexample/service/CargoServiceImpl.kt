package com.example.cargoexample.service

import com.example.cargoexample.service.dto.CargoDto
import com.example.cargoexample.exception.CargoNotFoundException
import com.example.cargoexample.model.Cargo
import com.example.cargoexample.repository.CargoRepository
import org.springframework.stereotype.Service

@Service
class CargoServiceImpl(private val cargoRepository: CargoRepository) : CargoService {
    override fun getAll(pageIndex: Int): List<CargoDto> =
        cargoRepository.getAll(pageIndex)
            .map { it.toDto() }

    override fun getById(id: Int): CargoDto =
        cargoRepository.findById(id)
            ?.toDto()
            ?: throw CargoNotFoundException(id)

    override fun create(cargoDto: CargoDto): CargoDto =
        cargoRepository.create(cargoDto.toModel())
            .toDto()

    override fun batchCreate(cargoDtos: List<CargoDto>): Int =
        cargoRepository.batchCreate(cargoDtos.map { dto -> dto.toModel() })
            .size

    override fun update(id: Int, cargoDto: CargoDto): CargoDto =
        cargoRepository.update(id, cargoDto.toModel())
            .toDto()

    override fun delete(id: Int) {
        cargoRepository.delete(id)
    }

    override fun getStatistics(): Map<String, Int> =
        cargoRepository.getStatistics()


    private fun Cargo.toDto() =
        CargoDto(
            id = id,
            title = title,
            brand = brand,
            passengerCount = passengerCount,
            loadCapacity = loadCapacity,
        )

    private fun CargoDto.toModel() =
        Cargo(
            id = id,
            title = title,
            brand = brand,
            passengerCount = passengerCount,
            loadCapacity = loadCapacity,
        )
}