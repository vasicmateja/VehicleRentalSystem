package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityById(Long id);
    City findCityByName(String name);

    List<City> findAll();
}
