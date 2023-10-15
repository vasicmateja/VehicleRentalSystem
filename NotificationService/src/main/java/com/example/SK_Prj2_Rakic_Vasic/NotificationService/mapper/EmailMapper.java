package com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.Email;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.*;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.repository.NotificationTypeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmailMapper {

    private NotificationTypeRepository notificationTypeRepository;

    private String myMail = "sktestprj2@gmail.com";
    public EmailMapper(NotificationTypeRepository notificationTypeRepository) {
        this.notificationTypeRepository = notificationTypeRepository;
    }


    public EmailDto emailToEmailDto(Email email){
        EmailDto emailDto = new EmailDto();

        emailDto.setFrom(email.getFrom());
        emailDto.setTo(email.getTo());
        emailDto.setSubject(email.getSubject());
        emailDto.setContent(email.getContent());

        return emailDto;
    }

    public Email activationEmailDtoToEmail(ActivationEmailDto activationEmailDto){
        Email email = new Email();

        String text = "Postovani " + activationEmailDto.getFirstName() + " " + activationEmailDto.getLastName() + " , verifikujte se na sledeci link:" + activationEmailDto.getLink();
        email.setContent(text);

        email.setFrom(myMail);
        email.setTo(activationEmailDto.getEmail());

        //VIDI STA CES SA OVIM
        email.setSubject(String.valueOf(notificationTypeRepository.findNotificationTypeByTypeName("ACTIVATION_MAIL").get()));
        email.setDate(String.valueOf(LocalDate.now()));


        return email;
    }

    public Email changePasswordDtoToEmail(ChangePasswordDto changePasswordDto){
        Email email = new Email();

        email.setSubject(String.valueOf(notificationTypeRepository.findNotificationTypeByTypeName("CHANGE_PASSWORD_MAIL").get()));
        email.setTo(changePasswordDto.getEmail());

        String text = "Stara lozinka " + changePasswordDto.getOldPassword() + " je promenjena na "+ changePasswordDto.getNewPassword();
        email.setContent(text);
        //TODO
        email.setFrom(myMail);
        email.setDate(String.valueOf(LocalDate.now()));


        return email;
    }

    public Email reservationEmailDtoToEmail(ReservationEmailDto reservationEmailDto){
        Email email = new Email();

        email.setSubject(String.valueOf(notificationTypeRepository.findNotificationTypeByTypeName("RESERVATION_MAIL").get()));
        email.setTo(reservationEmailDto.getEmail());
        String text = "Uspesno ste rezervisali " + reservationEmailDto.getCar() + "od " + reservationEmailDto.getStartDate() + " u duzini od" + reservationEmailDto.getDurationInDays();
        email.setContent(text);
        email.setFrom(myMail);
        email.setDate(String.valueOf(LocalDate.now()));

        return email;
    }

    public Email cancelReservationDtoToEmail(CancelReservationDto cancelReservationDto){
        Email email = new Email();

        email.setSubject(String.valueOf(notificationTypeRepository.findNotificationTypeByTypeName("CANCELATION_MAIL").get()));
        email.setTo(cancelReservationDto.getEmail());
        String text = "Rezervacija " + cancelReservationDto.getReservation() + " je otkazana";
        email.setContent(text);
        email.setFrom(myMail);
        email.setDate(String.valueOf(LocalDate.now()));


        return email;
    }

    public Email reviewDtoToEmail(ReviewDto reviewDto){
        Email email = new Email();

        email.setSubject(String.valueOf(notificationTypeRepository.findNotificationTypeByTypeName("REVIEW")));
        email.setTo(reviewDto.getEmail());
        String text = "Nova recenzija: \n" + "Ocena: " + reviewDto.getGrade() +"\nKomentar:" + reviewDto.getComment();
        email.setContent(text);
        email.setFrom(myMail);
        email.setDate(String.valueOf(LocalDate.now()));
        return email;
    }



}
