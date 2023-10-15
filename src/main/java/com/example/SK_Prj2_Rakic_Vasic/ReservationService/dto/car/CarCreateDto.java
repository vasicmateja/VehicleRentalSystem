package com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.CarType;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Company;

public class CarCreateDto {

    private String model;
    private String company;
    private String type;
    private Double pricePerDay;
    private boolean reserved;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
