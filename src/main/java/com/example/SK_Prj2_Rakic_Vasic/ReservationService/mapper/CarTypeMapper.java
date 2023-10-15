package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.CarType;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeDto;
import org.springframework.stereotype.Component;

@Component
public class CarTypeMapper {
    public CarTypeMapper() {
    }
    public CarTypeDto carTypeToCarTypeDto (CarType carType){
        CarTypeDto carTypeDto = new CarTypeDto();
        carTypeDto.setId(carType.getId());
        carTypeDto.setName(carType.getName());

        return carTypeDto;
    }
    public CarType carTypeCreateDtoToVehicleType(CarTypeCreateDto carTypeCreateDto){
        CarType carType = new CarType();
        carType.setName(carTypeCreateDto.getName());
        return carType;
    }
}
