package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.City;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.city.CityDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.CityMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CityRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class CityServiceImplementation implements CityService {

    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public CityServiceImplementation(CityMapper cityMapper, CityRepository cityRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDto findCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(()->new NotFoundException("City ciji je id:" + id + "nije pronadjen"));

        return cityMapper.cityToCityDto(city);
    }

    @Override
    public List<CityDto> listAll() {
        List<CityDto> cityDtos = new ArrayList<>();
        List<City> cities = cityRepository.findAll();

        for (City city : cities) {
            cityDtos.add(cityMapper.cityToCityDto(city));
        }

        return cityDtos;
    }


    @Override
    public CityDto createCity(CityCreateDto cityCreateDto) {
        City city = cityMapper.cityCreateDtoToCity(cityCreateDto);
        cityRepository.save(city);
        return cityMapper.cityToCityDto(city);
    }

    @Override
    public CityDto updateCity(CityDto cityDto) {
        City city = cityRepository.getOne(cityDto.getId());

        city.setName(cityDto.getName());

        cityRepository.save(city);

        return cityDto;
    }

    @Override
    public Boolean deleteCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(()->new NotFoundException("City ciji je id:" + id + "nije pronadjen"));

        cityRepository.deleteById(id);
        return true;
    }
}
