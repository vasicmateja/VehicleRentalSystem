package com.example.SK_Prj2_Rakic_Vasic.NotificationService.service;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.*;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeDto;

import java.util.List;

public interface EmailService {

    List<EmailDto> findAllEmails(String authorization);

    EmailDto addActivationEmailToEmail(ActivationEmailDto activationEmailDto);

    EmailDto addChangePasswordDtoToEmail(ChangePasswordDto changePasswordDto);

    EmailDto addReservationEmailDtoToEmail(ReservationEmailDto reservationEmailDto);

    EmailDto addCancelReservationDtoToEmail(CancelReservationDto cancelReservationDto);

    EmailDto addReviewDtoToEmail(ReviewDto reviewDto);

    void sendSimpleMessage(String to, String subject, String content);

}
