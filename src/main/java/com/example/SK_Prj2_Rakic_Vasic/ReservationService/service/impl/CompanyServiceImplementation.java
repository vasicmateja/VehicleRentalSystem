package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Company;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.CompanyMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CityRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CompanyRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CompanyServiceImplementation implements CompanyService {
    private final CompanyRepository companyRepository;

    private CompanyMapper companyMapper;
    private final CityRepository cityRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository, CompanyMapper companyMapper, CityRepository cityRepository) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public CompanyDto findCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()->new NotFoundException("Company ciji je id:" + id + "nije pronadjen"));

        return companyMapper.companyToCompanyDto(company);
    }

    @Override
    public List<CompanyDto> listAll() {
        List<CompanyDto> companyDtos = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();

        for (Company company : companies) {
            System.out.println("\n GRAD = " + company.getCity().getName());
            companyDtos.add(companyMapper.companyToCompanyDto(company));
        }

        return companyDtos;
    }

    @Override
    public CompanyDto createCompany(CompanyCreateDto companyCreateDto) {
        Company company = companyMapper.companyCreateDtoToCompany(companyCreateDto);

        companyRepository.save(company);

        return companyMapper.companyToCompanyDto(company);
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto) {
        Company company = companyRepository.findCompanyById(companyDto.getId());

        company.setName(companyDto.getName());
        company.setCity(cityRepository.findCityByName(companyDto.getName()));
        company.setDescription(companyDto.getDescription());

        companyRepository.save(company);

        return companyDto;
    }

    @Override
    public Boolean deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()->new NotFoundException("Company ciji je id:" + id + "nije pronadjen"));

        companyRepository.delete(company);

        return true;
    }
}
