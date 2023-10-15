package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.City;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityMapper() {
    }

    public CityDto cityToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        return cityDto;
    }

    public City cityCreateDtoToCity(CityCreateDto cityCreateDto) {
        City city = new City();
        city.setName(cityCreateDto.getName());
        return city;
    }
}
