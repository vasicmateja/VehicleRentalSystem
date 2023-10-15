package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.CarType;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.carType.CarTypeDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.CarTypeMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarTypeRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CarTypeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CarTypeImplementation implements CarTypeService {
    private final CarTypeRepository carTypeRepository;

    private CarTypeMapper carTypeMapper;

    public CarTypeImplementation(CarTypeRepository carTypeRepository, CarTypeMapper carTypeMapper) {
        this.carTypeRepository = carTypeRepository;
        this.carTypeMapper = carTypeMapper;
    }

    @Override
    public CarTypeDto findVehicleType(Long id) {
        CarType carType = carTypeRepository.findById(id).orElseThrow(()->new NotFoundException("CarType ciji je id:" + id + "nije pronadjen"));
        return carTypeMapper.carTypeToCarTypeDto(carType);
    }

    @Override
    public CarTypeDto createVehicleType(CarTypeCreateDto carTypeCreateDto) {
        CarType carType = carTypeMapper.carTypeCreateDtoToVehicleType(carTypeCreateDto);
        carTypeRepository.save(carType);
        return carTypeMapper.carTypeToCarTypeDto(carType);
    }

    @Override
    public CarTypeDto updateVehicleType(CarTypeDto carTypeDto) {
        CarType carType = carTypeRepository.findById(carTypeDto.getId()).orElseThrow(()->new NotFoundException("CarType ciji je id:" + carTypeDto.getId() + "nije pronadjen"));

        carType.setId(carTypeDto.getId());
        carType.setName(carTypeDto.getName());

        carTypeRepository.save(carType);
        return carTypeDto;
    }

    @Override
    public void deleteVehicleType(Long id) {
        CarType carType = carTypeRepository.findById(id).orElseThrow(()->new NotFoundException("CarType ciji je id:" + id + "nije pronadjen"));

        carTypeRepository.delete(carType);
    }
}
