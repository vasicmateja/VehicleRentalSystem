package com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation;

public class ReservationCreateDto {
    private String car;
    private String startDate;
    private Integer duration;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
