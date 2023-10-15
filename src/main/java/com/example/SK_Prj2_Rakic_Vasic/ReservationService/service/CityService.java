package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityDto;


import java.util.List;

public interface CityService {
    CityDto findCity(Long id);

    List<CityDto> listAll();

    CityDto createCity(CityCreateDto cityCreateDto);

    CityDto updateCity(CityDto cityDto);

    Boolean deleteCity(Long id);
}
