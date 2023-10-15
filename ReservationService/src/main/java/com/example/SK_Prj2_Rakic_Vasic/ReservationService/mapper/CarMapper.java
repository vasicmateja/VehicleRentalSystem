package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Car;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarTypeRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    private CarTypeRepository repository;
    private CompanyRepository companyRepository;

    public CarMapper(CarTypeRepository repository, CompanyRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    public CarDto carToCarDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setCompany(car.getCompany().getName());
        carDto.setModel(car.getModel());
        carDto.setType(car.getType().getName());
        carDto.setReserved(car.isReserved());
        carDto.setPricePerDay(car.getPricePerDay());


       return carDto;
    }

    public Car carCreateDtoToCar(CarCreateDto carCreateDto){
        Car car = new Car();

        car.setModel(carCreateDto.getModel());
        car.setPricePerDay(carCreateDto.getPricePerDay());
        car.setType(repository.findCarTypeByName(carCreateDto.getType()));
        car.setCompany(companyRepository.findCompanyByName(carCreateDto.getCompany()));
        car.setReserved(false);

        return car;
    }
}
