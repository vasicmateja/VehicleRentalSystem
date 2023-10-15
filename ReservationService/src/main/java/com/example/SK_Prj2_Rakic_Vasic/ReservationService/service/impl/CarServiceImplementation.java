package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;


import com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Car;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Reservation;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car.CarDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.CarMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarTypeRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CompanyRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.ReservationRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CarService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CarServiceImplementation implements CarService {

    private CarMapper carMapper;
    private final CarRepository carRepository;
    private final CompanyRepository companyRepository;
    private final CarTypeRepository carTypeRepository;
    private final ReservationRepository reservationRepository;
    private MessageHelper messageHelper;


    public CarServiceImplementation(CarMapper carMapper, CarRepository carRepository, CompanyRepository companyRepository, CarTypeRepository carTypeRepository, ReservationRepository reservationRepository, MessageHelper messageHelper) {
        this.carMapper = carMapper;
        this.carRepository = carRepository;
        this.companyRepository = companyRepository;
        this.carTypeRepository = carTypeRepository;
        this.reservationRepository = reservationRepository;
        this.messageHelper = messageHelper;
    }

    @Override
    public CarDto findCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()->new NotFoundException("Car ciji je id:" + id + "nije pronadjen"));
        return carMapper.carToCarDto(car);
    }

    @Override
    public List<CarDto> listAvailableCars(String startDate, String endDate) throws ParseException {
        List<Car> vehicles = carRepository.findAll();



       // vehicles = filterByAvailability(vehicles, startDate, endDate);
        //TODO RESI OVO SA LINIJOM IZNAD

        System.out.println("\n"+ vehicles + "\n");
        List<CarDto> vehicleDtoList = mapCars(vehicles);
        return vehicleDtoList;
    }

    @Override
    public CarDto createCar(CarCreateDto carCreateDto) {
        Car car = carMapper.carCreateDtoToCar(carCreateDto);
        System.out.println(car.getModel()+"\n" +  car.getCompany().getName()+"\n" + car.getType()+"\n" + car.getPricePerDay());
        carRepository.save(car);
        return carMapper.carToCarDto(car);
    }

    @Override
    public CarDto update(CarDto carDto) {
        Car car = carRepository.findById(carDto.getId()).orElseThrow(()->new NotFoundException("Car ciji je id:" + carDto.getId() + "nije pronadjen"));

        car.setId(carDto.getId());
        car.setCompany(companyRepository.findCompanyByName(carDto.getCompany()));
        car.setModel(carDto.getModel());
        car.setType(carTypeRepository.findCarTypeByName(carDto.getType()));
        car.setReserved(carDto.isReserved());
        car.setPricePerDay(carDto.getPricePerDay());

        carRepository.save(car);
        return carDto;
    }

    @Override
    public Boolean deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(()->new NotFoundException("Car ciji je id:" + id + "nije pronadjen"));

        carRepository.delete(car);
        return true;
    }

    private List<Car> filterByAvailability(List<Car> cars, String startDate, String endDate) throws ParseException {
        List<Car> filtered = new ArrayList<>();

        for (Car car : cars) {
            Reservation reservation = reservationRepository.findReservationByCar(car.getModel());
            if (reservation == null) {
                filtered.add(car);
                continue;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date start = simpleDateFormat.parse(startDate);
            Date end = simpleDateFormat.parse(endDate);
            Date reservationStartDate = simpleDateFormat.parse(reservation.getStartDate());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(reservationStartDate);
            calendar.add(Calendar.DATE, + reservation.getDuration());
            Date reservationEndDate = calendar.getTime();

            if (start.before(reservationStartDate) && end.after(reservationStartDate) || start.before(reservationEndDate) && end.after(reservationEndDate) || start.before(reservationStartDate) && end.after(reservationEndDate) || start.after(reservationStartDate) && end.before(reservationEndDate)) {
                continue;
            }

            filtered.add(car);
        }

        return filtered;
    }

    private List<CarDto> mapCars(List<Car> cars) {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            carDtoList.add(carMapper.carToCarDto(car));
        }

        return carDtoList;
    }
}
