package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resevation/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/create")
    public ResponseEntity<CityDto> createCity(@RequestBody CityCreateDto cityCreateDto) {
        return new ResponseEntity<>(cityService.createCity(cityCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.updateCity(cityDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CityDto>> listCars() {
        return new ResponseEntity<>(cityService.listAll(), HttpStatus.OK);
    }
}