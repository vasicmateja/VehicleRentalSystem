package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("reservation/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    public ResponseEntity<CarDto> createCar(@RequestBody CarCreateDto carCreateDto) {
        return new ResponseEntity<>(carService.createCar(carCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto vehicleDto) {
        return new ResponseEntity<>(carService.update(vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/listAvailable")
    public ResponseEntity<List<CarDto>> listCars(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        System.out.println("\n" + startDate);
        System.out.println("\n" + endDate);
        return new ResponseEntity<>(carService.listAvailableCars(startDate, endDate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable Long id){
        return new ResponseEntity<Boolean>(carService.deleteCar(id), HttpStatus.OK);
    }


}
