package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;


import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarById(Long id);
    Car findCarByModel(String model);

    List<Car> findAll();
}
