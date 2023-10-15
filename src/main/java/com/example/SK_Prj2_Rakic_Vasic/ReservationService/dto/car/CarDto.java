package com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.car;

public class CarDto {
    private Long id;
    private String model;
    private String type;
    private String company;
    private Double pricePerDay;
    private boolean reserved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
