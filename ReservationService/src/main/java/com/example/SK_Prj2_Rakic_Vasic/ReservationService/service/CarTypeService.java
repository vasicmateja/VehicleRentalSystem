package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeDto;

public interface CarTypeService {

    CarTypeDto findVehicleType(Long id);

    CarTypeDto createVehicleType(CarTypeCreateDto vehicleTypeCreateDto);

    CarTypeDto updateVehicleType(CarTypeDto vehicleTypeDto);

    void deleteVehicleType(Long id);
}
