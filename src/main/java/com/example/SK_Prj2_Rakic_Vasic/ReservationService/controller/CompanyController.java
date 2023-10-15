package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company.CompanyDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resevation/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createFirm(@RequestBody CompanyCreateDto companyCreateDto) {
        return new ResponseEntity<>(companyService.createCompany(companyCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<CompanyDto> updateFirm(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.updateCompany(companyDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDto>> listVehicles() {
        return new ResponseEntity<>(companyService.listAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(companyService.deleteCompany(id), HttpStatus.OK);
    }
}
