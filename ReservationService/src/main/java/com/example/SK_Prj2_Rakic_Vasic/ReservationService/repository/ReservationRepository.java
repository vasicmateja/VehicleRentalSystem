package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findReservationById(Long id);
    Reservation findReservationByCar(String vehicle);

    List<Reservation> findAll();
}
