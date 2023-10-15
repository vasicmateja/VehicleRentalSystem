package com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.company;


public class CompanyCreateDto {
    private String name;
    private String description;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
