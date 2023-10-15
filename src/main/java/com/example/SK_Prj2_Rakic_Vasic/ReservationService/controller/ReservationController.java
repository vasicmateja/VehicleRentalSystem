package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("resevation/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationCreateDto reservationCreateDto) {
        return new ResponseEntity<>(reservationService.createRent(reservationCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto) {
        return new ResponseEntity<>(reservationService.updateRent(reservationDto), HttpStatus.OK);
    }


    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Boolean> cancelReservation(@PathVariable Long id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }
}
