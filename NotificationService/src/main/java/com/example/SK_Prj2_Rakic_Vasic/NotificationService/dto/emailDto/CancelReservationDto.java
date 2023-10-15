package com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto;

public class CancelReservationDto {

    private String email;
    private String company;
    private String reservation;

    public CancelReservationDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }
}
