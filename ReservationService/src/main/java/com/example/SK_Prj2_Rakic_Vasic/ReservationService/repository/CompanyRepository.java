package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findCompanyById(Long id);

    List<Company> findAll();
    Company findCompanyByName(String name);
}
