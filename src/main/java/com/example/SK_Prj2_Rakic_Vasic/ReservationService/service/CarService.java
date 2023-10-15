package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarDto;

import java.text.ParseException;
import java.util.List;

public interface CarService {
    CarDto findCar(Long id);

    List<CarDto> listAvailableCars(String startDate, String endDate) throws ParseException;

    CarDto createCar(CarCreateDto vehicleCreateDto);

    CarDto update(CarDto vehicleDto);

    Boolean deleteCar(Long id);
}
