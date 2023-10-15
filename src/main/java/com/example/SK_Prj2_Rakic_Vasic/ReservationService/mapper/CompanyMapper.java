package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Company;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CityRepository;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    private CityRepository cityRepository;

    public CompanyMapper(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CompanyDto companyToCompanyDto(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setDescription(company.getDescription());
        companyDto.setCity(company.getCity().getName());
        return companyDto;
    }

    public Company companyCreateDtoToCompany(CompanyCreateDto companyCreateDto){
        Company company = new Company();
        company.setName(companyCreateDto.getName());
        company.setDescription(companyCreateDto.getDescription());
        company.setCity(cityRepository.findCityByName(companyCreateDto.getCity()));
        return company;
    }
}
