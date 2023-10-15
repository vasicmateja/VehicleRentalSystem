package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long> {

    CarType findCarTypeById(Long id);
    CarType findCarTypeByName(String name);

    List<CarType> findAll();
}
