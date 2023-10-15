package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Reservation;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    private CarRepository carRepository;

    public ReservationMapper(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ReservationDto reservationToReservationDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationDto.getId());
        reservationDto.setCar(reservation.getCar().getModel());
        reservationDto.setDurationInDays(reservation.getDuration());
        reservationDto.setStartDate(reservation.getStartDate());

        return reservationDto;
    }

    public Reservation reservationCreateDtoToReservation(ReservationCreateDto reservationCreateDto){

        Reservation reservation = new Reservation();
        reservation.setCar(carRepository.findCarByModel(reservationCreateDto.getCar()));
        reservation.setDuration(reservationCreateDto.getDuration());
        reservation.setStartDate(reservationCreateDto.getStartDate());

        //TODO KAKO DOHVVATITI TRENUTNOG USERA?
        reservation.setUserId(6L);
        return reservation;
    }

}
