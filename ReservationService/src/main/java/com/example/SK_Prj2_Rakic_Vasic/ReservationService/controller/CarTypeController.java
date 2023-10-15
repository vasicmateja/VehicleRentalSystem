package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CarTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resevation/carType")
public class CarTypeController {
    private final CarTypeService carTypeService;

    public CarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<CarTypeDto> createVehicleType(@RequestBody CarTypeCreateDto carTypeCreateDto) {
        return new ResponseEntity<>(carTypeService.createVehicleType(carTypeCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CarTypeDto> updateVehicleType(@RequestBody CarTypeDto carTypeDto) {
        return new ResponseEntity<>(carTypeService.updateVehicleType(carTypeDto), HttpStatus.OK);
    }
}
