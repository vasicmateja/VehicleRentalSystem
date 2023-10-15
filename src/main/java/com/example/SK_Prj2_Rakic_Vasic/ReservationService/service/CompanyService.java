package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;


import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto findCompany(Long id);

    List<CompanyDto> listAll();

    CompanyDto createCompany(CompanyCreateDto companyCreateDto);

    CompanyDto updateCompany(CompanyDto companyDto);

    Boolean deleteCompany(Long id);
}
