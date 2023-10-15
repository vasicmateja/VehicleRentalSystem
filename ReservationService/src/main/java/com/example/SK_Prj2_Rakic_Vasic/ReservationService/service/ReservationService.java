package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationDto;

public interface ReservationService {
    ReservationDto findReservation(Long id);
    ReservationDto createRent(ReservationCreateDto reservationCreateDto);
    ReservationDto updateRent(ReservationDto reservationDto);
    Boolean deleteReservation(Long id);

}
