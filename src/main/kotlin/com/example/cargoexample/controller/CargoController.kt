package com.example.cargoexample.controller

import com.example.cargoexample.service.dto.CargoDto
import com.example.cargoexample.service.CargoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cargo")
@Api(description = "Transport Controller")
class CargoController(private val cargoService: CargoService) {
    @GetMapping
    @ApiOperation("Getting a complete list of transport")
    fun getAll(@RequestParam(name = "page", defaultValue = "0", required = false) pageIndex: Int): List<CargoDto> =
        cargoService.getAll(pageIndex)

    @GetMapping("/{id}")
    @ApiOperation("Getting a vehicle by its ID")
    fun getById(@PathVariable id: Int): CargoDto = cargoService.getById(id)

    @PostMapping
    @ApiOperation("Creating a new vehicle")
    fun create(@RequestBody cargoDto: CargoDto) = cargoService.create(cargoDto)

    @PostMapping("/batch")
    @ApiOperation("Batch creation of new vehicles")
    fun batchCreate(@RequestBody cargoDtos: List<CargoDto>) = cargoService.batchCreate(cargoDtos)

    @PutMapping("/{id}")
    @ApiOperation("Upgrading an Existing Vehicle")
    fun update(@PathVariable id: Int, @RequestBody cargoDto: CargoDto) = cargoService.update(id, cargoDto)

    @DeleteMapping("/{id}")
    @ApiOperation("Deleting a vehicle by its ID")
    fun delete(@PathVariable id: Int) {
        cargoService.delete(id)
    }

    @GetMapping("/statistics")
    @ApiOperation("Statistics: number of cars of each brand")
    fun getStatistics() = cargoService.getStatistics()
}