package com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Car;

public class ReservationDto {

    private Long id;
    private Long userId;
    private String car;
    //TODO STRING ILI CAR
    private String startDate;
    private Integer durationInDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
